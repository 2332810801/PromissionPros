package com.dj.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class QueryVo {
    private int page;
    private int rows;
    private String keyword;

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
