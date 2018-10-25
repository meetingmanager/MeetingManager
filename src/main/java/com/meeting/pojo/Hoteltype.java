package com.meeting.pojo;

public class Hoteltype {
    private Integer htnum;

    private Long mnum;

    private String httime;

    private String etplace;

    private String ettype;

    public Integer getHtnum() {
        return htnum;
    }

    public void setHtnum(Integer htnum) {
        this.htnum = htnum;
    }

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public String getHttime() {
        return httime;
    }

    public void setHttime(String httime) {
        this.httime = httime == null ? null : httime.trim();
    }

    public String getEtplace() {
        return etplace;
    }

    public void setEtplace(String etplace) {
        this.etplace = etplace == null ? null : etplace.trim();
    }

    public String getEttype() {
        return ettype;
    }

    public void setEttype(String ettype) {
        this.ettype = ettype == null ? null : ettype.trim();
    }
}