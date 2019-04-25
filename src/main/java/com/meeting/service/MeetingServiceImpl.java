package com.meeting.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.MeetingMapper;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.MeetingExample;
import com.meeting.pojo.MeetingExample.Criteria;
@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	MeetingMapper meetingMapper;

	public Meeting getMeetingById(long id) {
		// TODO Auto-generated method stub
		
		return meetingMapper.selectByPrimaryKey(id);
	}

	
	
	/*
	 * 创建会议
	 * 形参
	 * 	必录项：会议名称，会议时间，会议地点，会议内容
	 * 	非必录项：会议议程，会议指南
	 * 	
	 * 业务
	 * 	会议号：自增字段
	 *  会议创建时间：必录，当前时间
	 *  会议结束时间：非必录
	 *  会议状态：必录，枚举值（进行（1），结束（0））
	 *  
	 *  是否需要用餐：必录（是（1），否（0，默认））
	 *  是否需要住宿：必录（是（1），否（0，默认））
	 *  
	 *  
	 * 		
	 * 
	 * */
	@Override
	public void createMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		//设置创建时间
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		meeting.setMcreate(timestamp);
		
		//设置会议状态,进行
		meeting.setMflag(1);
		
		//设置是否用餐，否
		meeting.setMeat(0);
		
		//设置是否住宿，否
		meeting.setMhotel(0);
		
		//设置会议类型
		meeting.setMtype(0);
		meetingMapper.insert(meeting);
	}

	
	/*
	 * 根据用户id获取会议信息
	 * */
	@Override
	public List<Meeting> findMeetingView(String userid) {
		// TODO Auto-generated method stub
	
		MeetingExample example = new MeetingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Meeting> meetings = meetingMapper.selectByExample(example);
		return meetings;
	}


	/*
	 * 根据mnum获取会议
	 * */
	@Override
	public Meeting findMeetingById(long mnum) {
		// TODO Auto-generated method stub
		Meeting meeting = meetingMapper.selectByPrimaryKey(mnum);
		return meeting;
	}


	/*
	 * 更新会议信息
	 * */
	@Override
	public void updateMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		Meeting meeting2 = meetingMapper.selectByPrimaryKey(meeting.getMnum());
		meeting2.setMname(meeting.getMname());
		meeting2.setMtime(meeting.getMtime());
		meeting2.setMguide(meeting.getMguide());
		meeting2.setMflow(meeting.getMflow());
		meeting2.setMcontent(meeting.getMcontent());
		meeting2.setMplace(meeting.getMplace());
		meetingMapper.updateByPrimaryKey(meeting2);
		
	}



	@Override
	public void updateMeetingById(Meeting meeting) {
		// TODO Auto-generated method stub
		meetingMapper.updateByPrimaryKey(meeting);
	}


	/*
	 * 根据会议名称模糊查询会议
	 * */
	@Override
	public List<Meeting> selectMeetingByName(String name, String userid,long mnum) {
		// TODO Auto-generated method stub
		MeetingExample example = new MeetingExample();
		Criteria criteria = example.createCriteria();
		name = "%"+name+"%";
		List<Meeting> meetings = new ArrayList<Meeting>();
		//mnum=0,表示查询用户自己创建的会议
		if(mnum == 0){
			criteria.andMnameLike(name);
			criteria.andUseridEqualTo(userid);
			meetings = meetingMapper.selectByExample(example);
		}
		//mnum！=0，表示用户加入的会议
		else{
			criteria.andMnameLike(name);
			criteria.andMnumEqualTo(mnum);
			meetings = meetingMapper.selectByExample(example);
		}
		return meetings;
	}

}
