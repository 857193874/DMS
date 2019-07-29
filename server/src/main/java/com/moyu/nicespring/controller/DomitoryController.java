package com.moyu.nicespring.controller;


import com.moyu.nicespring.entity.Domitory;
import com.moyu.nicespring.service.DomitoryService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dms/api/v1/domitory")
public class DomitoryController {

    @Autowired
    DomitoryService domitoryService;

    /**
     * @author moyu
     * @info 获取所有宿舍信息
     * @author chenmc
     * @date 2018/3/3 16:11
     * @param
     * @return com.moyu.bean.Msg
     *
     *
     */
    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAllDomitory(){
       return Msg.success().add("allDomitory",domitoryService.getAll());
    }

    @GetMapping("/query/{domitoryId}")
    @ResponseBody
    public Msg getDomitory(@PathVariable("domitoryId") Integer id){
        return Msg.success().add("domitory",domitoryService.getDomitoryById(id));
    }

    @GetMapping("/query/domitoryId")
    @ResponseBody
    public Msg getDomitoryID(){
        return Msg.success().add("domitoryids",domitoryService.selectPrimaryKey());
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg saveDomitory(Domitory domitory){
        domitoryService.saveDomitory(domitory);
        return Msg.success();
    }

    @DeleteMapping("/del/{domitoryId}")
    public Msg delDomitory(@PathVariable("domitoryId") Integer id){
        domitoryService.deleteDomitory(id);
        return Msg.success();
    }

    @PostMapping("/update/{domitoryId}")
    @ResponseBody
    public Msg updateDomitory(Domitory domitory,@PathVariable("domitoryId") Integer domitoryId ){
        domitory.setDomitoryId(domitoryId);
        domitoryService.updateDomitory(domitory);
        return Msg.success();
    }


}
