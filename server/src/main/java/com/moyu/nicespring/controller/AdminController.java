package com.moyu.nicespring.controller;


import com.moyu.nicespring.entity.Admin;
import com.moyu.nicespring.service.AdminService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dms/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAllAdmin(){
        return Msg.success().add("alladmins",adminService.getAll());
    }

    @GetMapping("/query/{adminId}")
    @ResponseBody
    public Msg getAdminById(@PathVariable("adminId") Integer id){
        return Msg.success().add("admin",adminService.getAdminById(id));
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg saveAdmin(Admin admin){
        adminService.saveAdmin(admin);
        return Msg.success();
    }

    @PostMapping("/update/{adminId}")
    @ResponseBody
    public Msg updateAdmin(Admin admin ,@PathVariable("adminId") Integer adminId){
        admin.setAdminId(adminId);
        adminService.updateAdmin(admin);
        return Msg.success();
    }

    @DeleteMapping("/del/{adminId}")
    @ResponseBody
    public Msg delAdmin(@PathVariable("adminId") Integer id){
        adminService.delAdmin(id);
        return Msg.success();
    }

}
