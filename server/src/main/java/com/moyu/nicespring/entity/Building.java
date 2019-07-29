package com.moyu.nicespring.entity;

public class Building {
    private Integer buildingId;

    private String buildingName;

    private String buildingIntroduction;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingIntroduction() {
        return buildingIntroduction;
    }

    public void setBuildingIntroduction(String buildingIntroduction) {
        this.buildingIntroduction = buildingIntroduction == null ? null : buildingIntroduction.trim();
    }
}