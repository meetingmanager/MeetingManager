package com.meeting.mapper;

import com.meeting.pojo.Subprojiect;
import com.meeting.pojo.SubprojiectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubprojiectMapper {
    int countByExample(SubprojiectExample example);

    int deleteByExample(SubprojiectExample example);

    int deleteByPrimaryKey(Integer snum);

    int insert(Subprojiect record);

    int insertSelective(Subprojiect record);

    List<Subprojiect> selectByExample(SubprojiectExample example);

    Subprojiect selectByPrimaryKey(Integer snum);

    int updateByExampleSelective(@Param("record") Subprojiect record, @Param("example") SubprojiectExample example);

    int updateByExample(@Param("record") Subprojiect record, @Param("example") SubprojiectExample example);

    int updateByPrimaryKeySelective(Subprojiect record);

    int updateByPrimaryKey(Subprojiect record);
}