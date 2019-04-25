package com.meeting.service;

import java.util.List;
import java.util.Map;

import com.meeting.pojo.Eattype;
import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.UserEat;

/*
 * 用餐
 * */
public interface EatService {
	
	//根据主键获取用餐信息
	public Eattype selectByPrimaryKey(int etnum);
	
	public List<Eattype> selectEat(long mnum);
	
	//添加用餐
	public void insertEat(Eattype eattype);
	
	//更新用餐
	public void updateEat(Eattype eattype);
	
	//删除用餐类型
	public void deleteEat(int etnum);
	
	//根据mnum、etnum和pflag获取未分配的参会人员
	public List<ExpandedEat> selectEatParticipants(Map<String, Long> map);
	
	//根据参会人员号，用餐类型号，会议号添加用餐
	public void insertEatAarray(int[] pnumAarray,int etnum,long mnum);
	
	//根据参会人员号，会议号，查询用餐类型
	public List<Eattype> selectEattypeByPM(Map<String, Long> map);
	
	//根据会议号，用餐类型号，用餐类型号，查询用户信息
	public List<UserEat> selectUserByMnumEtnum(Map<String, Long> map);
	
	//删除某个人的用餐
	public void deleteSpecificEat(int eatnum);
}
