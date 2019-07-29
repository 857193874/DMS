package com.moyu.nicespring.service;

import com.moyu.nicespring.dao.AdminMapper;
import com.moyu.nicespring.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public List<Admin> getAll(){
        return adminMapper.selectByExample(null);
    }

    public Admin getAdminById(Integer id){
        return adminMapper.selectByPrimaryKey(id);
    }

    public void saveAdmin(Admin admin){
        adminMapper.insertSelective(admin);
    }

    public void delAdmin(Integer id){
        adminMapper.deleteByPrimaryKey(id);
    }

    public void updateAdmin(Admin admin){
        adminMapper.updateByPrimaryKeySelective(admin);
    }
}
