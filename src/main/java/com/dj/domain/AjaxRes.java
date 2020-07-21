package com.dj.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class AjaxRes {
    private boolean success;
    private String msg;

    public AjaxRes(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
