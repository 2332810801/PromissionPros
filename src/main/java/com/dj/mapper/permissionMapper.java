package com.dj.mapper;

import com.dj.domain.permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface permissionMapper {
    /*查询所有权限*/
    List<permission> selectAll();
    /*根据角色id查询权限*/
    List<permission> getPermissionById(Long rid);
}