package com.meeting.mapper;

import com.meeting.pojo.Eattype;
import com.meeting.pojo.EattypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EattypeMapper {
    int countByExample(EattypeExample example);

    int deleteByExample(EattypeExample example);

    int deleteByPrimaryKey(Integer etnum);

    int insert(Eattype record);

    int insertSelective(Eattype record);

    List<Eattype> selectByExample(EattypeExample example);

    Eattype selectByPrimaryKey(Integer etnum);

    int updateByExampleSelective(@Param("record") Eattype record, @Param("example") EattypeExample example);

    int updateByExample(@Param("record") Eattype record, @Param("example") EattypeExample example);

    int updateByPrimaryKeySelective(Eattype record);

    int updateByPrimaryKey(Eattype record);
}