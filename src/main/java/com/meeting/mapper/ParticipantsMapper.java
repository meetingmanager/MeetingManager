package com.meeting.mapper;

import com.meeting.pojo.Participants;
import com.meeting.pojo.ParticipantsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipantsMapper {
    int countByExample(ParticipantsExample example);

    int deleteByExample(ParticipantsExample example);

    int deleteByPrimaryKey(Integer pnum);

    int insert(Participants record);

    int insertSelective(Participants record);

    List<Participants> selectByExample(ParticipantsExample example);

    Participants selectByPrimaryKey(Integer pnum);

    int updateByExampleSelective(@Param("record") Participants record, @Param("example") ParticipantsExample example);

    int updateByExample(@Param("record") Participants record, @Param("example") ParticipantsExample example);

    int updateByPrimaryKeySelective(Participants record);

    int updateByPrimaryKey(Participants record);
}