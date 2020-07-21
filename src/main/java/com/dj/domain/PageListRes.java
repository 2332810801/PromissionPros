package com.dj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@ToString
public class PageListRes {
    private Long total;
    private List<?> rows=new ArrayList<>();

    public PageListRes() {
    }

    public PageListRes(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> row) {
        this.rows = row;
    }

}
