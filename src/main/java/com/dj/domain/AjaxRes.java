package com.dj.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class AjaxRes {
    private boolean success;//是否成功
    private String msg;//返回信息

    public AjaxRes(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
