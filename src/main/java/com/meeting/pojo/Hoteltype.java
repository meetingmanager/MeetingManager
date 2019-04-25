package com.meeting.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Hoteltype {
    private Integer htnum;

    private Long mnum;

    private String hotelplace;

    private String hoteltype;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date starttime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endtime;

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

    public String getHotelplace() {
        return hotelplace;
    }

    public void setHotelplace(String hotelplace) {
        this.hotelplace = hotelplace == null ? null : hotelplace.trim();
    }

    public String getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(String hoteltype) {
        this.hoteltype = hoteltype == null ? null : hoteltype.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}