package com.meeting.service;

import java.util.List;

import com.meeting.pojo.ExpandedSeat;
import com.meeting.pojo.Seat;

/*
 * 座位详情表
 * */
public interface SeatService {
	
	/*
	 * 查询某个用户在某个会议的座位
	 * */
	public int selectSeatInUserid(long mnum,int pnum);
	
	/*
	 * 根据会议号，查看未分配好座位的人员
	 * */
	public List<ExpandedSeat> selectNotDistributeByMnum(long mnum);
	
	/*
	 * 根据会议号，查看以分配好座位的人员
	 * */
	public List<Seat> selectDistributeByMnum(long mnum);
	
	/*
	 * 根据会议号，删除会议座位
	 * */
	public void deleteSeat(long mnum);
	
	/*
	 * 插入座位
	 * */
	public void insertSeat(Seat seat);
	
}
