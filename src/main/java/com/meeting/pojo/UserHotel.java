package com.meeting.pojo;

/*
 * 用于存放用户数据和该用户参加某个用餐的标识符
 * */
public class UserHotel {

	String username;
	String phone;
	String usersex;
	int hnum;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	
	
	public int getHnum() {
		return hnum;
	}
	public void setHnum(int hnum) {
		this.hnum = hnum;
	}
	@Override
	public String toString() {
		return "UserEat [username=" + username + ", phone=" + phone + ", usersex=" + usersex + ", hnum=" + hnum
				+ "]";
	}
	
	
}
