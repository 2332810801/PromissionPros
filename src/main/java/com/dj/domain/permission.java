package com.dj.domain;

import java.io.Serializable;

public class permission implements Serializable {
    private Long pid;

    /**
     * 权限名称
     */
    private String pname;

    /**
     * 描述
     */
    private String presources;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPresources() {
        return presources;
    }

    public void setPresources(String presources) {
        this.presources = presources;
    }
}