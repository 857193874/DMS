package com.moyu.nicespring.entity;

public class Maintain {
    private Integer maintainId;

    private Integer domitoryId;

    private String maintainTime;

    private String status;

    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public Integer getDomitoryId() {
        return domitoryId;
    }

    public void setDomitoryId(Integer domitoryId) {
        this.domitoryId = domitoryId;
    }

    public String getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(String maintainTime) {
        this.maintainTime = maintainTime == null ? null : maintainTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}