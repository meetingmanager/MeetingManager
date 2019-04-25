package com.meeting.service;



import com.meeting.pojo.User;


public interface UserService {
	
	//新增一个用户记录
	public void InsertUser(User user);
	
	//根据id查询用户记录
	public User findUserById(String userid);
	
	//根据phone查询用户记录
	public User findUserByPhone(String phone);

	//修改用户信息
	public void updateUser(User user);
	
	
}
