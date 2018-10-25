package com.meeting.mapper;

import com.meeting.pojo.Eat;
import com.meeting.pojo.EatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EatMapper {
    int countByExample(EatExample example);

    int deleteByExample(EatExample example);

    int deleteByPrimaryKey(Integer eeatnum);

    int insert(Eat record);

    int insertSelective(Eat record);

    List<Eat> selectByExample(EatExample example);

    Eat selectByPrimaryKey(Integer eeatnum);

    int updateByExampleSelective(@Param("record") Eat record, @Param("example") EatExample example);

    int updateByExample(@Param("record") Eat record, @Param("example") EatExample example);

    int updateByPrimaryKeySelective(Eat record);

    int updateByPrimaryKey(Eat record);
}