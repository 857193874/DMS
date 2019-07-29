package com.moyu.nicespring.service;


import com.moyu.nicespring.dao.OutMapper;
import com.moyu.nicespring.entity.Out;
import com.moyu.nicespring.entity.OutExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moyu
 * @info 外出服务
 * @date 18-3-5 下午3:59
 * @param
 * @return
 */
@Service
public class OutService {

    @Autowired
    OutMapper outMapper;

    public List<Out> getAll(){
        return outMapper.selectByExample(null);
    }

    public Out getOutById(Integer outId){
        return outMapper.selectByPrimaryKey(outId);
    }

    public List<Out> getOutByStudentUsername(String studentUsername){
        OutExample outExample=new OutExample();
        OutExample.Criteria criteria=outExample.createCriteria();
        criteria.andOutStudentidEqualTo(studentUsername);
        return outMapper.selectByExample(outExample);
    }

    public void saveOut(Out out){
        outMapper.insertSelective(out);
    }

    public void updateOut(Out out){
        outMapper.updateByPrimaryKeySelective(out);
    }

    public void delOut(Integer outId){
        outMapper.deleteByPrimaryKey(outId);
    }

}
