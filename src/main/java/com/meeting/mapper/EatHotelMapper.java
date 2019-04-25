package com.meeting.mapper;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import com.meeting.pojo.Eattype;
import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.ExpandedHotel;
import com.meeting.pojo.Hoteltype;
import com.meeting.pojo.User;
import com.meeting.pojo.UserEat;
import com.meeting.pojo.UserHotel;

public interface EatHotelMapper {

	public List<ExpandedEat> selectSeatParticipants(Map<String, Long> map);
	
	/*
	 * 多表查询：eat,eattype
	 * 1、根据mnum、pnum查询eat表的etnum
	 * 2、根据etnum,查询eattype表记录
	 * */
	public List<Eattype> selectEatTypeByUserid(Map<String,Long> map);
	
	/*
	 * 多表查询：user,participants,eat
	 * 查询内容：返回参加某个会议的某个用餐类型的用户信息
	 * 传入参数：mnum,etnum
	 * 
	 * */
	public List<UserEat> selectUserByMnumEtnum(Map<String, Long> map);
	
	public List<ExpandedHotel> selectHotelParticipants(Map<String, Long> map);
	
	/*
	 * 多表查询：user,participants,hotel
	 * 查询内容：返回参加某个会议的某个用餐类型的用户信息
	 * 传入参数：mnum,hnum
	 * 
	 * */
	public List<UserHotel> selectUserByMnumHtnum(Map<String, Long> map);
	
	public List<Hoteltype> selectHotelTypeByUserid(Map<String, Long> map);
	
}
