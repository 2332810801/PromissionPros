package com.dj.service;

import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.role;

import java.util.List;

public interface RoleService {
    /*查询角色*/
    PageListRes getRoles(QueryVo vo);
    /*添加角色*/
    void saveRole(role role);
    /*修改角色*/
    void updateRole(role role);
    /*删除角色*/
    void deleteRole(Long rid);
}
