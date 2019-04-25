package com.meeting.service;

import java.util.List;

import com.meeting.pojo.Participants;

public interface ParticipantsService {
	
	//���ݲλ���Ա�Ż�ȡ�λ���Ա��Ϣ
	public Participants findPartipantsByPnum(int pnum);

	//���ݲλ���Ա������ȡ�λ���Ա��Ϣ
	public List<Participants> findPartipantsByPname(String pname,long mnum);
	
	//���ݻ���Ż�ȡ�λ���Ա
	public List<Participants> findPartipantsByMnum(long mnum);
	
	//���ݲλ���Ա���޸Ĳλ���Ա�λ�״̬
	public void updatePartipants(int pnum,int pflag);
	
	//���ݻ���ţ����زλ���Ա״̬��Ϊ1����׼�λᣩ��2���ܾ��λᣩ
	public List<Participants> findPartpantsByMP(long mnum);
	
	//�������ĳ������
	public void applyJoinMeeting(Participants participants);
	
	//�����û����ͻ���Ż�ȡ�λ���Ա��
	public int selectPnumByMnumAndUserid(long mnum,String userid);
}
