package com.meeting.pojo;

import java.util.Date;

public class Subprojiect {
    private Integer snum;

    private Long mnum;

    private String sname;

    private String splace;

    private Date stime;

    private String sconment;

    private String sflow;

    private String sguide;

    private String mflag;

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSplace() {
        return splace;
    }

    public void setSplace(String splace) {
        this.splace = splace == null ? null : splace.trim();
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public String getSconment() {
        return sconment;
    }

    public void setSconment(String sconment) {
        this.sconment = sconment == null ? null : sconment.trim();
    }

    public String getSflow() {
        return sflow;
    }

    public void setSflow(String sflow) {
        this.sflow = sflow == null ? null : sflow.trim();
    }

    public String getSguide() {
        return sguide;
    }

    public void setSguide(String sguide) {
        this.sguide = sguide == null ? null : sguide.trim();
    }

    public String getMflag() {
        return mflag;
    }

    public void setMflag(String mflag) {
        this.mflag = mflag == null ? null : mflag.trim();
    }
}