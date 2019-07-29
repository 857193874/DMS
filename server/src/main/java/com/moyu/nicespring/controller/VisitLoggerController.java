package com.moyu.nicespring.controller;

import com.moyu.nicespring.service.VisitLoggerService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dms/api/v1/visit")
public class VisitLoggerController {


    @Autowired
    VisitLoggerService visitLoggerService;

    @GetMapping("/query/logger")
    public Msg getVisitloggerByPageUrl(){
        return Msg.success().add("logger",visitLoggerService.getVisitloggerByPageUrl("main"));
    }

    @PostMapping("/add")
    public Msg setMainAdd(){
        visitLoggerService.setMainAdd("main");
        return Msg.success();
    }
}
