package com.meeting.mapper;

import com.meeting.pojo.Seattype;
import com.meeting.pojo.SeattypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeattypeMapper {
    int countByExample(SeattypeExample example);

    int deleteByExample(SeattypeExample example);

    int deleteByPrimaryKey(Integer seatnum);

    int insert(Seattype record);

    int insertSelective(Seattype record);

    List<Seattype> selectByExample(SeattypeExample example);

    Seattype selectByPrimaryKey(Integer seatnum);

    int updateByExampleSelective(@Param("record") Seattype record, @Param("example") SeattypeExample example);

    int updateByExample(@Param("record") Seattype record, @Param("example") SeattypeExample example);

    int updateByPrimaryKeySelective(Seattype record);

    int updateByPrimaryKey(Seattype record);
}