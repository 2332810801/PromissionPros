package com.dj.web;

import com.dj.domain.AjaxRes;
import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.role;
import com.dj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    @RequestMapping("/role")
    public String employee(){
        return "role";
    }

    @Autowired
    RoleService service;
    /*查询角色*/
    @RequestMapping("/getRoles")
    @ResponseBody
    public PageListRes getRoles(QueryVo vo){
       return service.getRoles(vo);
    }

    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(role role){
        try {
            service.saveRole(role);
            return new AjaxRes(true,"添加成功");
        }catch (Exception e){
            return new AjaxRes(false,"添加失败");
        }
    }
    @RequestMapping("/updateRole")
    @ResponseBody
    public AjaxRes updateRole(role role){
        try {
            service.updateRole(role);
            return new AjaxRes(true,"更新成功");
        }catch (Exception e){
            return new AjaxRes(false,"更新失败");
        }
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid){
        try {
            service.deleteRole(rid);
            return new AjaxRes(true,"删除成功");
        }catch (Exception e){
            return new AjaxRes(false,"删除失败");
        }
    }
}
