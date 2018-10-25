package com.meeting.pojo;

public class Participants {
    private Integer pnum;

    private Long mnum;

    private String pname;

    private String psex;

    private String punit;

    private String ptitle;

    private String pphone;

    private String pchoice;

    private String pcode;

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Long getMnum() {
        return mnum;
    }

    public void setMnum(Long mnum) {
        this.mnum = mnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex == null ? null : psex.trim();
    }

    public String getPunit() {
        return punit;
    }

    public void setPunit(String punit) {
        this.punit = punit == null ? null : punit.trim();
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle == null ? null : ptitle.trim();
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone == null ? null : pphone.trim();
    }

    public String getPchoice() {
        return pchoice;
    }

    public void setPchoice(String pchoice) {
        this.pchoice = pchoice == null ? null : pchoice.trim();
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }
}