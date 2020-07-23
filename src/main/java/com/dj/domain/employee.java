package com.dj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter@Setter@ToString
public class employee implements Serializable {
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String realname;
    /**
     * 电话号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 入职日期
     */
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    /**
     * 离职状态
     */
    private Boolean state;
    /**
     * 是否管理员
     */
    private Boolean admin;
    /**
     * 部门信息
     */
    private department department;
    /**
     * 角色信息
     */
    private List<role> roles=new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public List<role> getRoles() {
        return roles;
    }

    public void setRoles(List<role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public com.dj.domain.department getDepartment() {
        return department;
    }

    public void setDepartment(com.dj.domain.department department) {
        this.department = department;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}