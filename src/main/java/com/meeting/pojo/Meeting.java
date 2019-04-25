package com.meeting.pojo;

import java.util.Date;

public class Meeting {
    private Long mnum;

    private String mname;

    private Date mtime;

    private String mplace;

    private String mcontent;

    private String mflow;

    private String mguide;

    private Date mcreate;

    private Date mend;

    private Integer mflag;

    private Integer meat;

    private Integer mhotel;

    private Integer mtype;

    private String userid;

    private String mimage;

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMplace() {
        return mplace;
    }

    public void setMplace(String mplace) {
        this.mplace = mplace == null ? null : mplace.trim();
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent == null ? null : mcontent.trim();
    }

    public String getMflow() {
        return mflow;
    }

    public void setMflow(String mflow) {
        this.mflow = mflow == null ? null : mflow.trim();
    }

    public String getMguide() {
        return mguide;
    }

    public void setMguide(String mguide) {
        this.mguide = mguide == null ? null : mguide.trim();
    }

    public Date getMcreate() {
        return mcreate;
    }

    public void setMcreate(Date mcreate) {
        this.mcreate = mcreate;
    }

    public Date getMend() {
        return mend;
    }

    public void setMend(Date mend) {
        this.mend = mend;
    }

    public Integer getMflag() {
        return mflag;
    }

    public void setMflag(Integer mflag) {
        this.mflag = mflag;
    }

    public Integer getMeat() {
        return meat;
    }

    public void setMeat(Integer meat) {
        this.meat = meat;
    }

    public Integer getMhotel() {
        return mhotel;
    }

    public void setMhotel(Integer mhotel) {
        this.mhotel = mhotel;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage == null ? null : mimage.trim();
    }
}