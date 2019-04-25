package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.GuestMapper;
import com.meeting.pojo.Guest;
import com.meeting.pojo.GuestExample;
import com.meeting.pojo.GuestExample.Criteria;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	GuestMapper guestMapper;
	@Override
	public void addGuest(long mnum, String[] gnameString, String[] gphoneString, String[] gtitleString,
			String[] gintroductionString) {
		
		
	}
	
	/*
	 * 根据会议号获取嘉宾信息
	 * */
	@Override
	public List<Guest> getGuest(long mnum) {
		// TODO Auto-generated method stub
		List<Guest> list = new ArrayList<Guest>();
		GuestExample example = new GuestExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(mnum);
		list = guestMapper.selectByExample(example);
		return list;
	}
	
	//添加嘉宾
	@Override
	public void insertGuest(Guest guest) {
		// TODO Auto-generated method stub
		guest.setGstate("出席");
		guestMapper.insert(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		guestMapper.updateByPrimaryKey(guest);
	}

	@Override
	public Guest getGuestById(int gnum) {
		// TODO Auto-generated method stub
		return guestMapper.selectByPrimaryKey(gnum);
	}

	@Override
	public void deleteGuest(int gnum) {
		// TODO Auto-generated method stub
		guestMapper.deleteByPrimaryKey(gnum);
	}

	
}
