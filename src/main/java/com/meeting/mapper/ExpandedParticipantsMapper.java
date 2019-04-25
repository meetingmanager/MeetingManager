package com.meeting.mapper;

import com.meeting.pojo.Participants;
import com.meeting.pojo.ParticipantsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpandedParticipantsMapper {

    List<Participants> selectByExample(ParticipantsExample example);

}