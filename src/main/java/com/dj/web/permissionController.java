package com.dj.web;

import com.dj.domain.permission;
import com.dj.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class permissionController {
    @Autowired
    permissionService service;
    /*获取所有的权限*/
    @RequestMapping("/permissionList")
    @ResponseBody
    public List<permission> permissionList(){
        return service.permissionList();
    }

    /**根据id查询权限*/
    @RequestMapping("/getPermissionById")
    @ResponseBody
    public List<permission> getPermissionById(Long rid){
        return service.getPermissionById(rid);
    }
}
