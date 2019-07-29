package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.PowerMapper;
import com.moyu.nicespring.entity.Power;
import com.moyu.nicespring.entity.PowerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    @Autowired
    PowerMapper powerMapper;

    public List<Power> getAll(){
        return powerMapper.selectByExample(null);
    }

    public Power getPowerById(Integer integer){
        return powerMapper.selectByPrimaryKey(integer);
    }

    public List<Power> getPowerByBuildingID(Integer buildingId){
        PowerExample powerExample=new PowerExample();
        PowerExample.Criteria criteria=powerExample.createCriteria();
        criteria.andPowerBuildingIdEqualTo(buildingId);
        return powerMapper.selectByExample(powerExample);
    }

    public void savePower(Power power){
        powerMapper.insertSelective(power);
    }

    public void updatePower(Power power){
        powerMapper.updateByPrimaryKeySelective(power);
    }

    public void delPower(Integer powerId){
        powerMapper.deleteByPrimaryKey(powerId);
    }


}
