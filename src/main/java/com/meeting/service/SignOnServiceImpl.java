package com.meeting.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.ExpandedSignonMapper;
import com.meeting.mapper.SignonMapper;
import com.meeting.pojo.ExpandedSignon;
import com.meeting.pojo.Signon;
import com.meeting.pojo.SignonExample;
import com.meeting.pojo.SignonExample.Criteria;

/*
 * 签到
 * */
@Service
public class SignOnServiceImpl implements SignOnService {
	
	@Autowired
	SignonMapper signonMapper;
	
	@Autowired
	ExpandedSignonMapper expandedSignonMapper;
	/*
	 * 参会人员签到
	 * */
	@Override
	public Map<String, String> SignOnMeeting(Signon signon) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		SignonExample example = new SignonExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(signon.getMnum());
		criteria.andUseridEqualTo(signon.getUserid());
		List<Signon> list = signonMapper.selectByExample(example);
		Signon result_signon = list.get(0);
		
		if(result_signon.getSflag() == null){
			//未签到
			result_signon.setSflag(1);
			Date date = Calendar.getInstance().getTime();
			result_signon.setSigntime(date);
			signonMapper.updateByPrimaryKey(result_signon);
			map.put("msg", "签到成功");
		}else{
			//已签到
			map.put("msg", "已签到，不要重复签到！");
		}
	
		return map;
	}
	
	
	/*
	 * 根据会议号查询签到表
	 * */
	@Override
	public List<ExpandedSignon> SignOnList(Map<String, Long> map) {
		// TODO Auto-generated method stub
		List<ExpandedSignon> list = new ArrayList<ExpandedSignon>();
		
		list = expandedSignonMapper.selcetSignonList(map);
		//System.out.println(list.size()+"a1111111111111");
		return list;
	}

	
	@Override
	public int SignOnCount(long mnum) {
		// TODO Auto-generated method stub
		int count = expandedSignonMapper.countSignonList(mnum);
		return count;
	}

}
