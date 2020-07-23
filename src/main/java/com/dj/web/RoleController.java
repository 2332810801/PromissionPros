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

import java.util.List;

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

    /*添加角色*/
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
    /*修改角色*/
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

    /*删除角色*/
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
    /*查询角色*/
    @RequestMapping("/roleList")
    @ResponseBody
    public List<role> roleList(){
        return service.roleList();
    }

    /*根据员工id查询角色*/
    @RequestMapping("/getRoleById")
    @ResponseBody
    public List<Long> getRoleById(Long id){
        return service.getRoleById(id);

    }
}
