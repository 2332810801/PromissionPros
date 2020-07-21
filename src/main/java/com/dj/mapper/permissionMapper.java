package com.dj.mapper;

import com.dj.domain.permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface permissionMapper {
    List<permission> selectAll();

    List<permission> getPermissionById(Long rid);
}