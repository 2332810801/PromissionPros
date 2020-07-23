package com.dj.service;

import com.dj.domain.permission;

import java.util.List;

public interface permissionService {
    /*查询所有权限*/
    List<permission> permissionList();
    /*根据id查询权限*/
    List<permission> getPermissionById(Long rid);
}
