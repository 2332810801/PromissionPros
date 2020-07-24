package com.dj.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class menu implements Serializable {
    private Long id;

    private String text;

    private String url;

    private menu parent;
    private List<menu> children=new ArrayList<>();
    private permission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public menu getParent() {
        return parent;
    }

    public void setParent(menu parent) {
        this.parent = parent;
    }

    public List<menu> getChildren() {
        return children;
    }

    public void setChildren(List<menu> children) {
        this.children = children;
    }

    public permission getPermission() {
        return permission;
    }

    public void setPermission(permission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "menu{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                ", permission=" + permission +
                '}';
    }
}