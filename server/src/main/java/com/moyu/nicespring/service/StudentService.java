package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.StudentMapper;
import com.moyu.nicespring.entity.Student;
import com.moyu.nicespring.util.MD5Util;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    /**
     * 查询所有学生
     * @author moyu
     * @date 18-2-28 下午3:42
     * @param
     * @return java.util.List<com.moyu.bean.Student>
     */
    public List<Student> getAll(){
        return studentMapper.selectByExample(null);
    }


    /**
     * @author moyu
     * @info 根据username查询学生
     * @author chenmc
     * @date 2018/2/28 18:07
     * @param
     * @return com.moyu.bean.Student
     */
    public Student getStudentByUsername(String studentUsername){
        return studentMapper.selectByPrimaryKey(studentUsername);
    }

    public List<String> selectStudentUsernames(){
        return studentMapper.selectStudentKey();
    }
    /**
     * 保存学生信息
     * @author moyu
     * @date 18-2-28 下午3:48
     * @param
     * @return void
     */
    public void saveStudent(Student student){
        studentMapper.insertSelective(student);
    }

    /**
     * @author moyu
     * @info 删除学生信息
     * @date 18-2-28 下午3:51
     * @param
     * @return void
     */
    public void delStudent(String studentUsername){
        studentMapper.deleteByPrimaryKey(studentUsername);
    }
    /**
     * @author moyu
     * @info 更新学生信息
     * @date 18-2-28 下午3:52
     * @param
     * @return void
     */
    public void updateStudent(Student student){
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public boolean loginStudent(String studentUsername,String studentPassword){
        Student student=studentMapper.selectByPrimaryKey(studentUsername);
        String MD5Password=MD5Util.encode(studentPassword);
        if (student==null){
            return false;
        }else if(student.getStudentPassword().equals(MD5Password)){
            return true;
        }
        Log log= LogFactory.getLog(StudentService.class);
        return false;
    }

}
