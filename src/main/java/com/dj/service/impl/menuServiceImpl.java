package com.dj.service.impl;

import com.dj.domain.AjaxRes;
import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.menu;
import com.dj.mapper.menuMapper;
import com.dj.service.menuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class menuServiceImpl implements menuService {
    @Autowired
    menuMapper mapper;
    @Override
    public PageListRes menuList(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<menu> menus = mapper.menuList();
         return new PageListRes(page.getTotal(),menus);

    }

    @Override
    public List<menu> parentList() {
        return mapper.menuList();
    }

    @Override
    public void saveMenu(menu menu) {
        mapper.saveMenu(menu);
    }

    @Override
    public AjaxRes updateMenu(menu menu) {
        /*取出当前父菜单的id*/
        Long id = menu.getParent().getId();
        Long parentid=mapper.selectParenyId(id);
        if(menu.getId()==parentid){
            return new AjaxRes(false,"不能设置自己的子菜单为父菜单");
        }
       try {
           mapper.updateMenu(menu);
           return new AjaxRes(true,"更新成功");
       }catch (Exception e){
           return new AjaxRes(false,"更新失败");
       }
    }

    @Override
    public AjaxRes deletemenu(Long id) {
        /*更新菜单关系*/
        try {
            mapper.updatemenurel(id);
            mapper.deletemenu(id);
            return new AjaxRes(true,"删除成功");
        }catch (Exception e){
            return new AjaxRes(false,"删除失败");
        }


    }

    @Override
    public List<menu> getTreeData() {

        return mapper.getTreeData();
    }
}
