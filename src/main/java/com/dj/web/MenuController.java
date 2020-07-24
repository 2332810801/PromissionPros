package com.dj.web;

import com.dj.domain.*;
import com.dj.service.menuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    menuService service;
    @RequestMapping("/menu")
    public String employee(){
        return "menu";
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public PageListRes menuList(QueryVo vo){
       return service.menuList(vo);
    }


    @RequestMapping("/parentList")
    @ResponseBody
    public List<menu> parentList(){
        return service.parentList();
    }


    @RequestMapping("/saveMenu")
    @ResponseBody
    public AjaxRes saveMenu(menu menu){
        try {
            service.saveMenu(menu);
            return new AjaxRes(true,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxRes(false,"添加失败");
        }
    }
    @RequestMapping("/updateMenu")
    @ResponseBody
    public AjaxRes updateMenu(menu menu){
            return service.updateMenu(menu);
    }
    @RequestMapping("/deletemenu")
    @ResponseBody
    public AjaxRes deletemenu(Long id){
        return service.deletemenu(id);
    }

    /*获取树形菜单数据*/
    @RequestMapping("/getTreeData")
    @ResponseBody
    public List<menu> getTreeData(){
        List<menu> treeData = service.getTreeData();
        System.out.println(treeData);
        /*判断权限
        如果没有就移除
        * */
        /*获取用户*/
        Subject subject = SecurityUtils.getSubject();
        /*当前用户*/
        employee employee =(employee) subject.getPrincipal();
        if(!employee.getAdmin()){
            /*不是管理员 校验权限*/
            chePermission(treeData);
        }
        return treeData;
    }
    /*校验权限*/
    public void chePermission(List<menu> menus){
        Subject subject = SecurityUtils.getSubject();
        /*遍历所有菜单 及子菜单*/
        Iterator<menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            menu m = iterator.next();
            if(m.getPermission()!=null){
                /*判断当前菜单是否有权限  没有就移除*/
                String presources = m.getPermission().getPresources();
                if(!subject.isPermitted(presources)){
                    /*没有 从菜单集合 移除*/
                    iterator.remove();
                    continue;
                }
            }
            /*判断是否有子菜单 如果有 继续做校验*/
            if(m.getChildren().size()>0){
                chePermission(m.getChildren());
            }

        }
    }
}
