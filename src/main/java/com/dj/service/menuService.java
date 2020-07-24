package com.dj.service;

import com.dj.domain.AjaxRes;
import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.menu;

import java.util.List;

public interface menuService {

    PageListRes menuList(QueryVo vo);

    List<menu> parentList();

    void saveMenu(menu menu);

    AjaxRes updateMenu(menu menu);

    AjaxRes deletemenu(Long id);

    List<menu> getTreeData();
}
