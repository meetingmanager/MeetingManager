package com.meeting.mapper;

import com.meeting.pojo.Hoteltype;
import com.meeting.pojo.HoteltypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoteltypeMapper {
    int countByExample(HoteltypeExample example);

    int deleteByExample(HoteltypeExample example);

    int deleteByPrimaryKey(Integer htnum);

    int insert(Hoteltype record);

    int insertSelective(Hoteltype record);

    List<Hoteltype> selectByExample(HoteltypeExample example);

    Hoteltype selectByPrimaryKey(Integer htnum);

    int updateByExampleSelective(@Param("record") Hoteltype record, @Param("example") HoteltypeExample example);

    int updateByExample(@Param("record") Hoteltype record, @Param("example") HoteltypeExample example);

    int updateByPrimaryKeySelective(Hoteltype record);

    int updateByPrimaryKey(Hoteltype record);
}