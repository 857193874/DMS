package com.moyu.nicespring.dao;

import com.moyu.nicespring.entity.Visitlogger;
import com.moyu.nicespring.entity.VisitloggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitloggerMapper {
    long countByExample(VisitloggerExample example);

    int deleteByExample(VisitloggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Visitlogger record);

    int insertSelective(Visitlogger record);

    List<Visitlogger> selectByExample(VisitloggerExample example);

    Visitlogger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Visitlogger record, @Param("example") VisitloggerExample example);

    int updateByExample(@Param("record") Visitlogger record, @Param("example") VisitloggerExample example);

    int updateByPrimaryKeySelective(Visitlogger record);

    int updateByPrimaryKey(Visitlogger record);
}