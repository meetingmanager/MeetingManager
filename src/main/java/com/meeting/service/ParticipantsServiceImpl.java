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
	 * ���ݲλ���Ա�Ż�ȡ�λ���Ա��Ϣ
	 * */
	@Override
	public Participants findPartipantsByPnum(int pnum) {
		Participants participants = new Participants();
		participants = participantsMapper.selectByPrimaryKey(pnum);
		return participants;
	}

	/*
	 * ���ݲλ���Ա�Ż�ȡ�λ���Ա��Ϣ
	 * */
	@Override
	public List<Participants> findPartipantsByPname(String pname,long mnum) {
		pname = "%"+pname+"%";
		ParticipantsExample participantsExample = new ParticipantsExample();
		ParticipantsExample.Criteria criteria = participantsExample.createCriteria();
		criteria.andPnameLike(pname);
		criteria.andMnumEqualTo(mnum);
		List<Participants> participants = participantsMapper.selectByExample(participantsExample);
		return participants;
	}

	/*
	 * ���ݻ���Ż�ȡ�û���Ĳλ���Ա
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
	
	//���ݻ���źͲλ���Ա���޸Ĳλ���Ա�λ�״̬
	@Override
	public void updatePartipants(int pnum,int pflag) {
		// TODO Auto-generated method stub
		Participants participants = participantsMapper.selectByPrimaryKey(pnum);
		participants.setPflag(pflag);
		participantsMapper.updateByPrimaryKey(participants);
	}
	
	/*
	 * ���ݻ���ţ����زλ���Ա״̬��Ϊ1����׼�λᣩ��2���ܾ��λᣩ
	 * */
	@Override
	public List<Participants> findPartpantsByMP(long mnum) {
		// TODO Auto-generated method stub
		List list = new ArrayList<Participants>();
		ParticipantsExample example = new ParticipantsExample();
		Criteria criteria = example.createCriteria();
		//��ѯ�������λ���Ա״̬��Ϊ����0
		criteria.andPflagGreaterThan(0);
		//��ѯ�����������Ϊmnum
		criteria.andMnumEqualTo(mnum);
		criteria.andPflagBetween(1, 2);
		list = participantsMapper.selectByExample(example);
		return list;
	}
	
	/*
	 * �������ĳ������
	 * */
	@Override
	public void applyJoinMeeting(Participants participants) {
		// TODO Auto-generated method stub
		//�ж������Ƿ�Ϊ��
		if(participants.getPname() == null){
			participants.setPname("�����λ�");
		}
		//�ж��Ա��Ƿ�Ϊ��
		if(participants.getPsex() == null){
			participants.setPsex("δ֪");
		}
		//��״̬������Ϊ0(�������)
		participants.setPflag(0);
		
		participantsMapper.insert(participants);
		
	}
	
	/*
	 * �����û����ͻ���Ż�ȡ�λ���Ա��
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
