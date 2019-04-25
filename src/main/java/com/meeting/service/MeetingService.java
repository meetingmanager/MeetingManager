package com.meeting.service;

import java.util.List;

import com.meeting.pojo.Meeting;

public interface MeetingService {
	
	Meeting getMeetingById(long id);
	
	//创建会议
	void createMeeting(Meeting meeting);
	
	//会议试图
	List<Meeting> findMeetingView(String userid);
	
	//根据id查询会议
	Meeting findMeetingById(long nnum);
	
	//更新会议信息
	void updateMeeting(Meeting meeting);
	
	//根据主键修改会议信息
	void updateMeetingById(Meeting meeting);
	
	//根据会议名称模糊查询会议记录
	List<Meeting> selectMeetingByName(String name,String userid,long mnums);
}
