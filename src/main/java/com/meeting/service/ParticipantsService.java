package com.meeting.service;

import java.util.List;

import com.meeting.pojo.Participants;

public interface ParticipantsService {
	
	//根据参会人员号获取参会人员信息
	public Participants findPartipantsByPnum(int pnum);

	//根据参会人员姓名获取参会人员信息
	public List<Participants> findPartipantsByPname(String pname,long mnum);
	
	//根据会议号获取参会人员
	public List<Participants> findPartipantsByMnum(long mnum);
	
	//根据参会人员号修改参会人员参会状态
	public void updatePartipants(int pnum,int pflag);
	
	//根据会议号，返回参会人员状态码为1（批准参会）和2（拒绝参会）
	public List<Participants> findPartpantsByMP(long mnum);
	
	//申请加入某个会议
	public void applyJoinMeeting(Participants participants);
	
	//根据用户名和会议号获取参会人员号
	public int selectPnumByMnumAndUserid(long mnum,String userid);
}
