package com.meeting.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.EatHotelMapper;
import com.meeting.mapper.EatMapper;
import com.meeting.mapper.EattypeMapper;
import com.meeting.pojo.Eat;
import com.meeting.pojo.EatExample;
import com.meeting.pojo.Eattype;
import com.meeting.pojo.EattypeExample;
import com.meeting.pojo.EattypeExample.Criteria;
import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.UserEat;
/*
 * 住宿
 * */
@Service
public class EatServiceImpl implements EatService {
	
	@Autowired
	EattypeMapper eattypeMapper;
	
	@Autowired
	EatHotelMapper eatHotelMapper;
	
	@Autowired
	EatMapper eatMapper;
	/*
	 * 根据会议号查询该会议的用餐情况
	 * */
	@Override
	public List<Eattype> selectEat(long mnum) {
		// TODO Auto-generated method stub
		List<Eattype> list = new ArrayList<Eattype>();
		EattypeExample example = new EattypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andMnumEqualTo(mnum);
		list = eattypeMapper.selectByExample(example);
		return list;
	}
	
	/*
	 * 添加用餐
	 * */
	@Override
	public void insertEat(Eattype eattype) {
		// TODO Auto-generated method stub
		
		/*
		 * 设置时间
		 * */
		
		eattypeMapper.insert(eattype);
	}
	
	
	/*
	 * 更新
	 * */
	@Override
	public void updateEat(Eattype eattype) {
		// TODO Auto-generated method stub
		
		/*
		 * 设置时间
		 * */
		System.out.println("service"+eattype.getEttimestart());
		System.out.println("service"+eattype.getEttimeend());
		eattypeMapper.updateByPrimaryKey(eattype);
	}
	
	/*
	 * 根据主键获取用餐信息
	 * */
	@Override
	public Eattype selectByPrimaryKey(int etnum) {
		// TODO Auto-generated method stub
		return eattypeMapper.selectByPrimaryKey(etnum);
		
	}
	
	/*
	 * 根据主键删除用餐信息
	 * */
	@Override
	public void deleteEat(int etnum) {
		// TODO Auto-generated method stub
		eattypeMapper.deleteByPrimaryKey(etnum);
	}
	
	/*
	 * 根据mnum、etnum和pflag获取未分配的参会人员
	 */
	@Override
	public List<ExpandedEat> selectEatParticipants(Map<String, Long> map) {
		// TODO Auto-generated method stub
		
		//添加条件，pflag=1，表示批准入会
		map.put("pflag", (long) 1);
		List<ExpandedEat> list = eatHotelMapper.selectSeatParticipants(map);
		return list;
	}
	
	/*
	 * 根据参会人员号，用餐类型号，会议号添加用餐
	 * */
	@Override
	public void insertEatAarray(int[] pnumAarray, int etnum, long mnum) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<pnumAarray.length;i++){
			Eat eat = new Eat();
			eat.setPnum(pnumAarray[i]);
			eat.setEtnum(etnum);
			eat.setMnum(mnum);
			eatMapper.insert(eat);
		}
	}
	
	/*
	 * 根据参会人员号，会议号，查询用餐类型
	 * */
	@Override
	public List<Eattype> selectEattypeByPM(Map<String, Long> map) {
		// TODO Auto-generated method stub
		
		List<Eattype> list = eatHotelMapper.selectEatTypeByUserid(map);
		return list;
	}

	/*
	 * 根据会议号，用餐类型号，用餐类型号，查询用户信息
	 */
	@Override
	public List<UserEat> selectUserByMnumEtnum(Map<String, Long> map) {
		// TODO Auto-generated method stub
		List<UserEat> list = eatHotelMapper.selectUserByMnumEtnum(map);
		return list;
	}

	@Override
	public void deleteSpecificEat(int eatnum) {
		// TODO Auto-generated method stub
		eatMapper.deleteByPrimaryKey(eatnum);
	}

}
