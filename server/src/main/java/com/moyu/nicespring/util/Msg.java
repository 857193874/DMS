package com.moyu.nicespring.util;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private  int status;

    private  String msg;

    private Map<String,Object> data=new HashMap<String,Object>();

    public static Msg success(){
        Msg result =new Msg();
        result.setStatus(200);
        result.setMsg("处理成功");
        return result;
    }

    public static Msg fail(){
        Msg result=new Msg();
        result.setStatus(100);
        result.setMsg("处理失败!");
        return result;
    }

    public Msg add(String key,Object value){
        this.getData().put(key,value);
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
