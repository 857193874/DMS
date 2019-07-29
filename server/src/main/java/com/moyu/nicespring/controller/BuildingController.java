package com.moyu.nicespring.controller;


import com.moyu.nicespring.entity.Building;
import com.moyu.nicespring.service.BuildingService;
import com.moyu.nicespring.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dms/api/v1/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @GetMapping("/query/all")
    @ResponseBody
    public Msg getAllBuilding(){
        return Msg.success().add("allBuilding",buildingService.getAll());
    }

    @GetMapping("/query/buildingId")
    @ResponseBody
    public Msg getBuildingId(){
        return Msg.success().add("buildingids",buildingService.selectBuildingPrimaryKey());
    }

    @GetMapping("/query/{buildingId}")
    @ResponseBody
    public Msg getBuildingById(@PathVariable("buildingId") Integer buildingId){
        return Msg.success().add("building",buildingService.getBuildingById(buildingId));
    }

    @PostMapping("/save")
    @ResponseBody
    public Msg saveBuilding(Building building){
        buildingService.saveBuilding(building);
        return Msg.success();
    }

    @PostMapping("/update/{buildingId}")
    @ResponseBody
    public Msg updateBuilding(Building building,@PathVariable("buildingId") Integer buildingId){
        building.setBuildingId(buildingId);
        buildingService.updateBuilding(building);
        return Msg.success();
    }

    @DeleteMapping("/del/{buildingId}")
    @ResponseBody
    public Msg delBuilding(@PathVariable("buildingId") Integer buildingId){
        buildingService.delBuilding(buildingId);
        return Msg.success();
    }


}
