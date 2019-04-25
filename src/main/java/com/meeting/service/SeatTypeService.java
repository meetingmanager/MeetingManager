package com.meeting.service;

import java.util.List;

import com.meeting.pojo.Seattype;

public interface SeatTypeService {

	/*
	 * 根据会议号获取座位的行和列
	 * */
	public List<Seattype> selectByMnum(long mnum);
	
	/*
	 * 根据会议号删除座位表
	 * */
	public void deleteSeatyMnum(long mnum);
	
	/*
	 * 插入座位表
	 * */
	public void insertSeattype(Seattype seattype);
}
