package com.meeting.mapper;

import java.util.List;

import com.meeting.pojo.ExpandedSeat;

/*
 * 座位表seat扩展的mapper
 * */
public interface ExpandedSeatMapper {

	/*
	 * 多表查询（seat,participants）
	 * */
	List<ExpandedSeat> selectSeatParticipants(long mnum);
}
