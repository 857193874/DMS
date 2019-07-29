package com.moyu.nicespring.entity;

public class Visitlogger {
    private Integer id;

    private String pageurl;

    private String apiurl;

    private Long visitnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    public String getApiurl() {
        return apiurl;
    }

    public void setApiurl(String apiurl) {
        this.apiurl = apiurl == null ? null : apiurl.trim();
    }

    public Long getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(Long visitnum) {
        this.visitnum = visitnum;
    }
}