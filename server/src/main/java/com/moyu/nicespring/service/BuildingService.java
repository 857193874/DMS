package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.BuildingMapper;
import com.moyu.nicespring.entity.Building;
import com.moyu.nicespring.entity.BuildingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    BuildingMapper buildingMapper;

    public List<Building> getAll(){
        return buildingMapper.selectByExample(null);
    }

    public Building getBuildingById(Integer buildingId){
        return  buildingMapper.selectByPrimaryKey(buildingId);
    }

    public void saveBuilding(Building building){
        buildingMapper.insertSelective(building);
    }

    public void updateBuilding(Building building){
        buildingMapper.updateByPrimaryKeySelective(building);
    }

    public void delBuilding(Integer buildingId){
        buildingMapper.deleteByPrimaryKey(buildingId);
    }

    public List<Integer> selectBuildingPrimaryKey(){return  buildingMapper.selectPrimaryKey();}
}
