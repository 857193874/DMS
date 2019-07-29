package com.moyu.nicespring.service;

import com.moyu.nicespring.dao.VisitloggerMapper;
import com.moyu.nicespring.entity.Visitlogger;
import com.moyu.nicespring.entity.VisitloggerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class VisitLoggerService {
    @Autowired
    VisitloggerMapper visitloggerMapper;

    public Visitlogger getVisitloggerByPageUrl(String url){
        VisitloggerExample example=new VisitloggerExample();
        VisitloggerExample.Criteria criteria=example.createCriteria();
        criteria.andPageurlEqualTo(url);
        return visitloggerMapper.selectByExample(example).get(0);
    }

    public void setMainAdd(String url){
        VisitloggerExample example=new VisitloggerExample();
        VisitloggerExample.Criteria criteria=example.createCriteria();
        criteria.andPageurlEqualTo(url);
        Visitlogger visitlogger=visitloggerMapper.selectByExample(example).get(0);
        Long a=visitlogger.getVisitnum()+1;
        visitlogger.setVisitnum(a);
        visitloggerMapper.updateByPrimaryKeySelective(visitlogger);
    }
}
