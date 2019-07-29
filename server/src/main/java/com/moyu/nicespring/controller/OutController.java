package com.moyu.nicespring.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moyu.nicespring.entity.Out;
import com.moyu.nicespring.service.OutService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dms/api/v1/out")
public class OutController {

    @Autowired
    OutService outService;




    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAllOut(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,10);
        List<Out> outs =outService.getAll();
        PageInfo pageInfo=new PageInfo(outs);
        Msg msg=new Msg();
        msg.setMsg("查询全部外出信息成功");
        msg.setStatus(200);
        return msg.add("allOut",pageInfo);
    }

    @GetMapping("/query/{outId}")
    @ResponseBody
    public Msg getOutByOutId(@PathVariable("outId") Integer outId){
        return Msg.success().add("myout",outService.getOutById(outId));
    }

    @GetMapping("/query/bystudentusername")
    @ResponseBody
    public Msg getOutByStudentUsername(String studentUsername){

        List<Out> outs=outService.getOutByStudentUsername(studentUsername);
        if(outs!=null&&outs.size()>0){
            return Msg.success().add("out",outs);
        }
        return Msg.fail();

    }

    @PostMapping("/update/{outId}")
    @ResponseBody
    public Msg updateOut(Out out,@PathVariable("outId") Integer outId){
        out.setOutId(outId);
        Msg msg=new Msg();
        outService.updateOut(out);
        msg.setMsg("更新外出信息成功");
        msg.setStatus(200);
        return msg;
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg saveOut(Out out){
        Msg msg=new Msg();
        outService.saveOut(out);
        msg.setMsg("外出信息保存成功");
        msg.setStatus(200);
        return msg;
    }

    @DeleteMapping("/del/{outId}")
    @ResponseBody
    public Msg delOut(@PathVariable("outId") Integer outId){
        Msg msg=new Msg();
        outService.delOut(outId);
        msg.setStatus(200);
        msg.setMsg("删除外出信息成功");
        return msg;
    }
}
