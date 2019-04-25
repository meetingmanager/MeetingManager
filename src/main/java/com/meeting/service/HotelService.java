package com.meeting.service;

import java.util.List;
import java.util.Map;

import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.ExpandedHotel;
import com.meeting.pojo.Hotel;
import com.meeting.pojo.Hoteltype;
import com.meeting.pojo.UserHotel;

public interface HotelService {
	
	/*
	 * 根据主键查询住宿类型
	 * */
	public Hoteltype selectHotelByPrimaryKey(int htnum);
	/*
	 * 根据会议号查询住宿类型
	 * */
	public List<Hoteltype> selectHotelByMnum(long mnum);
	
	/*
	 * 更新用餐类型
	 * */
	public void updateHotel(Hoteltype hoteltype);
	
	/*
	 * 插入用餐类型
	 * */
	public void insertHotel(Hoteltype hoteltype);
	
	/*
	 * 删除用餐类型
	 * */
	public void deleteHotel(int htnum);
	
	//根据mnum、htnum和pflag获取未分配的参会人员
	public List<ExpandedHotel> selectHotelParticipants(Map<String, Long> map);
	
	//根据mnum,hynum获取用户信息
	public List<UserHotel> selectUserByHotel(Map<String, Long> map);
	
	//插入住宿人员
	public void insertHotel(Hotel hotel);
	
	//删除住宿人员
	public void deleteHotelTab(int hnum);
	
	//根据mnum,pnum获取住宿类型
	public List<Hoteltype> seleteHoteltypeByUserid(Map<String, Long> map);
}
