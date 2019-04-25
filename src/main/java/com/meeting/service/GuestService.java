package com.meeting.service;

import java.util.List;

import com.meeting.pojo.Guest;

public interface GuestService {

	/*
	 * 添加嘉宾
	 * */
	public void addGuest(long mnum,String[] gnameString,String[] gphoneString,
							String[] gtitleString,String[] gintroductionString);
	
	/*
	 * 根据会议号获取嘉宾信息
	 * */
	public List<Guest> getGuest(long mnum);
	
	//根据主键查询嘉宾
	public Guest getGuestById(int gnum);
	//添加嘉宾
	public void insertGuest(Guest guest);
	
	//更新嘉宾信息
	public void updateGuest(Guest guest);
	
	//删除嘉宾信息
	public void deleteGuest(int gnum);
	}
