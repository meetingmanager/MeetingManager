package com.meeting.pojo;

public class ExpandedHotel {

	int pnum;
	String pname;
	String userid;
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "ExpandedHotel [pnum=" + pnum + ", pname=" + pname + ", userid=" + userid + "]";
	}
	
}
