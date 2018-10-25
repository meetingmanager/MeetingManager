package com.meeting.mapper;

import com.meeting.pojo.Enroll;
import com.meeting.pojo.EnrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnrollMapper {
    int countByExample(EnrollExample example);

    int deleteByExample(EnrollExample example);

    int deleteByPrimaryKey(Integer rnum);

    int insert(Enroll record);

    int insertSelective(Enroll record);

    List<Enroll> selectByExample(EnrollExample example);

    Enroll selectByPrimaryKey(Integer rnum);

    int updateByExampleSelective(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByExample(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByPrimaryKeySelective(Enroll record);

    int updateByPrimaryKey(Enroll record);
}