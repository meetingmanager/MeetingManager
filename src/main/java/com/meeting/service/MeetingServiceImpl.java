package com.meeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.MeetingMapper;
import com.meeting.pojo.Meeting;
@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	MeetingMapper meetingMapper;

	public Meeting getMeetingById(long id) {
		// TODO Auto-generated method stub
		
		return meetingMapper.selectByPrimaryKey(id);
	}

}
