package com.dj.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class QueryVo {
    private int page;//当前页
    private int rows;//页码
    private String keyword;//搜索关键字

    @Override
    public String toString() {
        return "QueryVo{" +
                "page=" + page +
                ", rows=" + rows +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
