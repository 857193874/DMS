package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.MaintainMapper;
import com.moyu.nicespring.entity.Maintain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainService {
    @Autowired
    MaintainMapper maintainMapper;

    public List<Maintain> getAll(){
        return maintainMapper.selectByExample(null);
    }

    public Maintain getMaintainByMainrainId(Integer maintainId){
        return maintainMapper.selectByPrimaryKey(maintainId);
    }

    public List<Maintain> getMaintainByDomitoryId(Integer domitoryId){
        return maintainMapper.selectMaintainByDomitoryId(domitoryId);
    }

    public void saveMaintain(Maintain maintain){
        maintainMapper.insertSelective(maintain);
    }

    public void updateMaintain(Maintain maintain){
        maintainMapper.updateByPrimaryKeySelective(maintain);
    }

    public void delMaintain(Integer maintainId){
        maintainMapper.deleteByPrimaryKey(maintainId);
    }
}
