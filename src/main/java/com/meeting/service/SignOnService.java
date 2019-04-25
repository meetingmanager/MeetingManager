package com.meeting.service;

import java.util.List;
import java.util.Map;

import com.meeting.pojo.ExpandedSignon;
import com.meeting.pojo.Signon;

/*
 * 签到
 * */
public interface SignOnService {
	
	/*
	 * 根据会议号获取签到表
	 * */
	public List<ExpandedSignon> SignOnList(Map<String, Long> map);
	
	/*
	 * 参会人员签到
	 * */
	public Map<String, String> SignOnMeeting(Signon sginon);
	
	/*
	 * 签到表数
	 * */
	public int SignOnCount(long mnum);
}
