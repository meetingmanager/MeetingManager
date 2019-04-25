package com.meeting.pojo;

public class Image {
    private Integer imageid;

    private String imagurl;

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getImagurl() {
        return imagurl;
    }

    public void setImagurl(String imagurl) {
        this.imagurl = imagurl == null ? null : imagurl.trim();
    }
}