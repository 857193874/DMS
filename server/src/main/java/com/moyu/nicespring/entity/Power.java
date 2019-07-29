package com.moyu.nicespring.entity;

public class Power {
    private Integer powerId;

    private Double totalconsumption;

    private Double subsidyconsumption;

    private Double payconsumption;

    private Double freeconsumption;

    private Double price;

    private Integer powerBuildingId;

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public Double getTotalconsumption() {
        return totalconsumption;
    }

    public void setTotalconsumption(Double totalconsumption) {
        this.totalconsumption = totalconsumption;
    }

    public Double getSubsidyconsumption() {
        return subsidyconsumption;
    }

    public void setSubsidyconsumption(Double subsidyconsumption) {
        this.subsidyconsumption = subsidyconsumption;
    }

    public Double getPayconsumption() {
        return payconsumption;
    }

    public void setPayconsumption(Double payconsumption) {
        this.payconsumption = payconsumption;
    }

    public Double getFreeconsumption() {
        return freeconsumption;
    }

    public void setFreeconsumption(Double freeconsumption) {
        this.freeconsumption = freeconsumption;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPowerBuildingId() {
        return powerBuildingId;
    }

    public void setPowerBuildingId(Integer powerBuildingId) {
        this.powerBuildingId = powerBuildingId;
    }
}