package com.eking.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class CommonLanguage {
    private Long id;
    private int sysid;
    private int userid;
    private String chinese;
    private String english;
    private String Channel;
    private String remark;

    public CommonLanguage(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSysid() {
        return sysid;
    }

    public void setSysid(int sysid) {
        this.sysid = sysid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
