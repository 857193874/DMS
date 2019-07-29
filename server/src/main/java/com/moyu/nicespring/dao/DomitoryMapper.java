package com.moyu.nicespring.dao;

import com.moyu.nicespring.entity.Domitory;
import com.moyu.nicespring.entity.DomitoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomitoryMapper {
    long countByExample(DomitoryExample example);

    int deleteByExample(DomitoryExample example);

    int deleteByPrimaryKey(Integer domitoryId);

    int insert(Domitory record);

    int insertSelective(Domitory record);

    List<Domitory> selectByExample(DomitoryExample example);

    Domitory selectByPrimaryKey(Integer domitoryId);

    int updateByExampleSelective(@Param("record") Domitory record, @Param("example") DomitoryExample example);

    int updateByExample(@Param("record") Domitory record, @Param("example") DomitoryExample example);

    int updateByPrimaryKeySelective(Domitory record);

    int updateByPrimaryKey(Domitory record);

    List<Integer> selectPrimaryKey();
}