package com.meeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeting.mapper.UserMapper;
import com.meeting.pojo.User;
import com.meeting.pojo.UserExample;
import com.meeting.pojo.UserExample.Criteria;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	@Override
	public void InsertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);

	}
	@Override
	public User findUserById(String userid) {
		// TODO Auto-generated method stub 
		User user = userMapper.selectByPrimaryKey(userid);
	
		return user;
	}
	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> user = (List<User>) userMapper.selectByExample(userExample);
		if(user != null && user.size()>0 ){
			return user.get(0);
		}
		return null;
	}
	
	/*
	 * 修改用户信息
	 * */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
	}

}
