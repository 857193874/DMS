package com.moyu.nicespring.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moyu.nicespring.entity.Domitory;
import com.moyu.nicespring.entity.Student;
import com.moyu.nicespring.service.DomitoryService;
import com.moyu.nicespring.service.StudentService;
import com.moyu.nicespring.util.MD5Util;
import com.moyu.nicespring.util.Msg;
import com.moyu.nicespring.util.SymmetricEncoder;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/dms/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    DomitoryService domitoryService;


    Log log=LogFactory.getLog(StudentController.class);

    /**
     * @author moyu
     * @info 获取所有学生
     * @date 18-2-28 下午4:04
     * @param
     * @return com.moyu.bean.Msg
     */
    @RequestMapping(value = "/query/all",method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllStudent(@RequestParam(value = "pn",defaultValue = "1")Integer pn){

        PageHelper.startPage(pn,10);
     /*   Log log = LogFactory.getLog(StudentController.class);
        log.info("pn:"+pn);
*/
        List<Student> students=studentService.getAll();
        PageInfo pageInfo=new PageInfo(students);
        Msg msg=new Msg();
        msg.setMsg("查询全部学生信息成功");
        msg.setStatus(200);
        return msg.add("allStudentInfo",pageInfo);
    }

    /**
     * @author moyu
     * @info 根据学号查询学生信息
     * @author chenmc
     * @date 2018/2/28 18:17
     * @param studentUsername
     * @return com.moyu.bean.Msg
     */
    @RequestMapping(value = "/query/{studentUsername}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getStudentByUsername(@PathVariable("studentUsername") String studentUsername){
        Student student=studentService.getStudentByUsername(studentUsername);
        if (student==null){
            return  Msg.fail();
        }
        return Msg.success().add("studentInfo",student);
    }

      /**
           * @author moyu
           * @info 查询所有用户名
           * @author chenmc  
           * @date 2018/4/9 22:29
           * @param   
           * @return   
           */
    @GetMapping("query/all/StudentUsername")
    @ResponseBody
    public Msg selectStudentPrimaryKey(){
        return Msg.success().add("studentUsername",studentService.selectStudentUsernames());
    }

    /**
     * @author moyu
     * @info 学生保存(可进行校验)
     * @author chenmc
     * @date 2018/2/28 17:57
     * @param student, result
     * @return com.moyu.bean.Msg
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveStudent(@Valid  Student student, BindingResult result){
        if (result.hasErrors()) {

            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误字段名"+fieldError.getField());
                System.out.println("错误信息"+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            System.out.println("进入函数");
            return Msg.fail().add("errorFields", map);
        }else {
            student.setStudentPassword(MD5Util.encode(student.getStudentPassword()));
            studentService.saveStudent(student);
            return Msg.success();
        }
    }

    /**
     * @author moyu
     * @info 删除学生信息
     * @author chenmc
     * @date 2018/2/28 18:05
     * @param studentUsername
     * @return com.moyu.bean.Msg
     */
    @RequestMapping(value = "/del/{studentUsername}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delStudent(@PathVariable("studentUsername")String studentUsername){
        studentService.delStudent(studentUsername);
        return Msg.success();
    }

    /**
     * @author moyu
     * @info 学生信息更新
     * @author chenmc
     * @date 2018/3/4 16:23
     * @param student
     * @return com.moyu.bean.Msg
     */
    @ResponseBody
    @RequestMapping(value="/update/{studentUsername}",method = RequestMethod.POST)
    public Msg updateStudent(Student student,@PathVariable("studentUsername") String studentUsername){
        student.setStudentUsername(studentUsername);
        if (student.getStudentPassword()!=null){
            student.setStudentPassword(MD5Util.encode(student.getStudentPassword()));
        }
        studentService.updateStudent(student);
        return Msg.success();
    }

    @ResponseBody
    @PostMapping("/login")
    public Msg studentLogin(String studentUsername, String studentPassword, HttpSession session, HttpServletResponse response){
        if (studentService.loginStudent(studentUsername,studentPassword)){
            //session.setAttribute("studentUsername",studentUsername);
            Student student =studentService.getStudentByUsername(studentUsername);
            student.setStudentPassword(MD5Util.encode(student.getStudentPassword()));
            SymmetricEncoder symmetricEncoder=new SymmetricEncoder();
            String encrypt=symmetricEncoder.encrypt(studentUsername,"gzy");
            Cookie cookie=new Cookie("studentUsername",encrypt);
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            response.addCookie(cookie);
            Domitory domitory=domitoryService.getDomitoryById(student.getStudentDomitoryid());
            return Msg.success().add("student",student).add("domitory",domitory);

        }
        return Msg.fail();
    }

    @ResponseBody
    @GetMapping("/chacklogin")
    public Msg chackLogin(HttpSession session, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("studentUsername")){
                    SymmetricEncoder symmetricEncoder=new SymmetricEncoder();
                    String unencrypt=symmetricEncoder.decrypt(c.getValue(),"gzy");
                    Student student=studentService.getStudentByUsername(unencrypt);
                    System.out.println(student.getStudentName());
                    Domitory domitory=domitoryService.getDomitoryById(student.getStudentDomitoryid());
                    return Msg.success().add("student",student).add("domitory",domitory);
                }
            }
        }
        return Msg.fail().add("info","登录失效");

    }

    @ResponseBody
    @GetMapping("/logout")
    public Msg studentLogout(HttpSession session, HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("studentUsername")){
                    Cookie cookie=new Cookie("studentUsername","false");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return Msg.success().add("info","成功登出");
                }
            }
        }
        return Msg.fail().add("info","登录失效");
    }
}
