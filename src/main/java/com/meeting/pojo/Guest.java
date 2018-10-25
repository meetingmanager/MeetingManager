package com.meeting.pojo;

public class Guest {
    private Integer gnum;

    private Long mnum;

    private String gname;

    private String gphone;

    private String gtitle;

    private String gintroduction;

    private Integer gstate;

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone == null ? null : gphone.trim();
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle == null ? null : gtitle.trim();
    }

    public String getGintroduction() {
        return gintroduction;
    }

    public void setGintroduction(String gintroduction) {
        this.gintroduction = gintroduction == null ? null : gintroduction.trim();
    }

    public Integer getGstate() {
        return gstate;
    }

    public void setGstate(Integer gstate) {
        this.gstate = gstate;
    }
}