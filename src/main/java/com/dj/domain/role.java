package com.dj.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class role implements Serializable {
    private Long rid;

    private String rnum;

    /**
     * 角色名称
     */
    private String rname;

    private List<permission> permissions=new ArrayList<>();

    public List<permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<permission> permissions) {
        this.permissions = permissions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum == null ? null : rnum.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    @Override
    public String toString() {
        return "role{" +
                "rid=" + rid +
                ", rnum='" + rnum + '\'' +
                ", rname='" + rname + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        role other = (role) that;
        return (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getRnum() == null ? other.getRnum() == null : this.getRnum().equals(other.getRnum()))
            && (this.getRname() == null ? other.getRname() == null : this.getRname().equals(other.getRname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getRnum() == null) ? 0 : getRnum().hashCode());
        result = prime * result + ((getRname() == null) ? 0 : getRname().hashCode());
        return result;
    }
}