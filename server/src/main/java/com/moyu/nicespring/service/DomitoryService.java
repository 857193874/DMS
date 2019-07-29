package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.DomitoryMapper;
import com.moyu.nicespring.entity.Domitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomitoryService {
    @Autowired
    DomitoryMapper domitoryMapper;


    public List<Domitory> getAll(){
        return domitoryMapper.selectByExample(null);
    }

    public Domitory getDomitoryById(Integer id){
        return domitoryMapper.selectByPrimaryKey(id);
    }

    public void saveDomitory(Domitory domitory){
        domitoryMapper.insertSelective(domitory);
    }

    public void updateDomitory(Domitory domitory){
        domitoryMapper.updateByPrimaryKeySelective(domitory);
    }

    public void deleteDomitory(Integer id){
        domitoryMapper.deleteByPrimaryKey(id);
    }

    public List<Integer> selectPrimaryKey(){return domitoryMapper.selectPrimaryKey();}


}
