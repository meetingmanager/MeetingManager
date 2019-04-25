package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.SeatMapper;
import com.meeting.mapper.SeattypeMapper;
import com.meeting.pojo.SeatExample;
import com.meeting.pojo.Seattype;
import com.meeting.pojo.SeattypeExample;
import com.meeting.pojo.SeattypeExample.Criteria;

@Service
public class SeatTypeServiceImpl implements SeatTypeService{
	
	@Autowired
	SeattypeMapper seattypeMapper;
	
	@Override
	public List<Seattype> selectByMnum(long mnum) {
		// TODO Auto-generated method stub
		List<Seattype> list = new ArrayList<Seattype>();
		SeattypeExample example = new SeattypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(mnum);
		list = seattypeMapper.selectByExample(example);
		return list;
	}
	
	/*
	 * 根据会议号删除座位表
	 * */
	@Override
	public void deleteSeatyMnum(long mnum) {
		// TODO Auto-generated method stub
		SeattypeExample seattypeExample = new SeattypeExample();
		Criteria seattypeCriteria = seattypeExample.createCriteria();
		seattypeCriteria.andMnumEqualTo(mnum);
		seattypeMapper.deleteByExample(seattypeExample);
		
		SeatExample seatExample = new SeatExample();
		
		
	}
	
	/*
	 * 插入会议座位表
	 * */
	@Override
	public void insertSeattype(Seattype seattype) {
		// TODO Auto-generated method stub
		seattypeMapper.insert(seattype);
	}

}
