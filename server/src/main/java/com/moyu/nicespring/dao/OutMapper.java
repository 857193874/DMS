package com.moyu.nicespring.dao;

import com.moyu.nicespring.entity.Out;
import com.moyu.nicespring.entity.OutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutMapper {
    long countByExample(OutExample example);

    int deleteByExample(OutExample example);

    int deleteByPrimaryKey(Integer outId);

    int insert(Out record);

    int insertSelective(Out record);

    List<Out> selectByExample(OutExample example);

    Out selectByPrimaryKey(Integer outId);

    int updateByExampleSelective(@Param("record") Out record, @Param("example") OutExample example);

    int updateByExample(@Param("record") Out record, @Param("example") OutExample example);

    int updateByPrimaryKeySelective(Out record);

    int updateByPrimaryKey(Out record);
}