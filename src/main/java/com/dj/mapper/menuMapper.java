package com.dj.mapper;


import com.dj.domain.menu;

import java.util.List;

public interface menuMapper {
    List<menu> menuList();

    void saveMenu(menu menu);

    Long selectParenyId(Long id);

    void updateMenu(menu menu);

    void deletemenu(Long id);

    void updatemenurel(Long id);

    List<menu> getTreeData();
}