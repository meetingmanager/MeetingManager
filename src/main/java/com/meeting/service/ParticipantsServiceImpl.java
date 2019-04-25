package com.meeting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.ParticipantsMapper;
import com.meeting.pojo.Participants;
import com.meeting.pojo.ParticipantsExample;
import com.meeting.pojo.ParticipantsExample.Criteria;

@Service
public class ParticipantsServiceImpl implements ParticipantsService{
	
	@Autowired
	ParticipantsMapper participantsMapper;
	
	/*
	 * 根据参会人员号获取参会人员信息
	 * */
	@Override
	public Participants findPartipantsByPnum(int pnum) {
		Participants participants = new Participants();
		participants = participantsMapper.selectByPrimaryKey(pnum);
		return participants;
	}
	
	/*
	 * 根据会议号获取该会议的参会人员
	 * */
	@Override
	public List<Participants> findPartipantsByMnum(long mnum) {
		// TODO Auto-generated method stub
		ParticipantsExample example = new ParticipantsExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(mnum);
		List<Participants> list = participantsMapper.selectByExample(example);
		return list;
	}
	
	//根据会议号和参会人员号修改参会人员参会状态
	@Override
	public void updatePartipants(int pnum,int pflag) {
		// TODO Auto-generated method stub
		Participants participants = participantsMapper.selectByPrimaryKey(pnum);
		participants.setPflag(pflag);
		participantsMapper.updateByPrimaryKey(participants);
	}
	
	/*
	 * 根据会议号，返回参会人员状态码为1（批准参会）和2（拒绝参会）
	 * */
	@Override
	public List<Participants> findPartpantsByMP(long mnum) {
		// TODO Auto-generated method stub
		List list = new ArrayList<Participants>();
		ParticipantsExample example = new ParticipantsExample();
		Criteria criteria = example.createCriteria();
		//查询条件：参会人员状态号为大于0
		criteria.andPflagGreaterThan(0);
		//查询条件：会议号为mnum
		criteria.andMnumEqualTo(mnum);
		criteria.andPflagBetween(1, 2);
		list = participantsMapper.selectByExample(example);
		return list;
	}
	
	/*
	 * 申请加入某个会议
	 * */
	@Override
	public void applyJoinMeeting(Participants participants) {
		// TODO Auto-generated method stub
		//判断名字是否为空
		if(participants.getPname() == null){
			participants.setPname("匿名参会");
		}
		//判断性别是否为空
		if(participants.getPsex() == null){
			participants.setPsex("未知");
		}
		//将状态码设置为0(申请入会)
		participants.setPflag(0);
		
		participantsMapper.insert(participants);
		
	}
	
	/*
	 * 根据用户名和会议号获取参会人员号
	 * */
	@Override
	public int selectPnumByMnumAndUserid(long mnum, String userid) {
		// TODO Auto-generated method stub
		int pnum = 0;
		ParticipantsExample example = new ParticipantsExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(mnum);
		criteria.andUseridEqualTo(userid);
		List<Participants> list = participantsMapper.selectByExample(example);
		if(!list.isEmpty()){
			pnum = list.get(0).getPnum();
		}
		return pnum;
	}

	

}
