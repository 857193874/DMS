package com.moyu.nicespring.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moyu.nicespring.entity.Power;
import com.moyu.nicespring.service.PowerService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dms/api/v1/power")
public class PowerController {

    @Autowired
    PowerService powerService;

    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn){

        PageHelper.startPage(pn,10);
        List<Power> list=powerService.getAll();
        PageInfo info=new PageInfo(list);
        return Msg.success().add("allPower",info);
    }

    @GetMapping("/query/{powerId}")
    @ResponseBody
    public Msg getPowerById(@PathVariable("powerId") Integer powerId){
        return Msg.success().add("power",powerService.getPowerById(powerId));
    }

    @GetMapping("/query/bybuilding")
    @ResponseBody
    public Msg getPowerByBuildingId(Integer buildingId){
        List<Power> powers=powerService.getPowerByBuildingID(buildingId);
        if (powers!=null&&powers.size()>0){
            return Msg.success().add("power",powers);
        }
        return Msg.fail();
    }

    @PostMapping("/update/{powerId}")
    @ResponseBody
    public Msg updatePower(Power power , @PathVariable("powerId") Integer powerId){
        powerService.updatePower(power);
        return Msg.success();
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg savePower(Power power){
        powerService.savePower(power);
        return Msg.success();
    }

    @DeleteMapping("/del/{powerId}")
    @ResponseBody
    public Msg delPower(@PathVariable("powerId") Integer powerId){
        powerService.delPower(powerId);
        return Msg.success();
    }


}
