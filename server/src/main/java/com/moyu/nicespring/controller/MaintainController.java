package com.moyu.nicespring.controller;


import com.moyu.nicespring.entity.Maintain;
import com.moyu.nicespring.service.MaintainService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dms/api/v1/maintain")
public class MaintainController {

    @Autowired
    MaintainService maintainService;

    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAll(){

        return Msg.success().add("allMaintain",maintainService.getAll());
    }

    @GetMapping("/query/maintainid/{maintainId}")
    @ResponseBody
    public Msg getMaintianByMaintainId(@PathVariable("maintainId") Integer maintainId){
        return Msg.success().add("maintain",maintainService.getMaintainByMainrainId(maintainId));
    }

    @GetMapping("/query/domitoryid/{domitoryId}")
    @ResponseBody
    public Msg getMaintianByDomitoryId(@PathVariable("domitoryId") Integer domitoryId){
        return Msg.success().add("maintain",maintainService.getMaintainByDomitoryId(domitoryId));
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg saveMaintain(Maintain maintain){
        maintainService.saveMaintain(maintain);
        return Msg.success();
    }

    @PostMapping("/update/{maintainId}")
    @ResponseBody
    public Msg updateMaintain(Maintain maintain,@PathVariable("maintainId") Integer maintainId){
        maintain.setMaintainId(maintainId);
        maintainService.updateMaintain(maintain);
        return Msg.success();
    }

    @DeleteMapping("/del/{maintainId}")
    @ResponseBody
    public Msg delMaintain(@PathVariable("maintainId") Integer maintainId){
        maintainService.delMaintain(maintainId);
        return Msg.success();
    }

}
