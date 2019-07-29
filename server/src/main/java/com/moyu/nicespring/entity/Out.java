package com.moyu.nicespring.entity;

public class Out {
    private Integer outId;

    private String outStudentid;

    private String outDate;

    private String outRemark;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public String getOutStudentid() {
        return outStudentid;
    }

    public void setOutStudentid(String outStudentid) {
        this.outStudentid = outStudentid == null ? null : outStudentid.trim();
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate == null ? null : outDate.trim();
    }

    public String getOutRemark() {
        return outRemark;
    }

    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark == null ? null : outRemark.trim();
    }
}