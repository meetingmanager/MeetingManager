package com.meeting.common;

import java.util.Date;

/*
 * 会议返回数据
 * 会议名，时间，会议状态
 * */
public class MeetingView {

	private String mname;
	private Date mtime;
	private int mflag;
	private long mnum;
	private String url;
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public int getMflag() {
		return mflag;
	}
	public void setMflag(int mflag) {
		this.mflag = mflag;
	}
	public long getMnum() {
		return mnum;
	}
	public void setMnum(long mnum) {
		this.mnum = mnum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
