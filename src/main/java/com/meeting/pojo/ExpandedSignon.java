package com.meeting.pojo;

import java.util.Date;

public class ExpandedSignon {
    private Integer signid;

    private String userid;

    private Long mnum;

    private Integer sflag;

    private Date signtime;
    
    private User user;

    public ExpandedSignon() {
		
	}
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSignid() {
        return signid;
    }

    public void setSignid(Integer signid) {
        this.signid = signid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public Integer getSflag() {
        return sflag;
    }

    public void setSflag(Integer sflag) {
        this.sflag = sflag;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }
}