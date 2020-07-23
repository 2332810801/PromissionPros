package com.dj.mapper;

import com.dj.domain.QueryVo;
import com.dj.domain.role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface roleMapper {
    /*查询角色*/
    List<role> getRoles(QueryVo vo);
    /*添加角色*/
    void saveRole(role role);
    /*添加角色权限*/
    void saveRoleAndPermissRel(@Param("rid") Long rid, @Param("pid") Long pid);
    /*删除角色权限*/
    void deletePermissionRel(Long rid);
    /*修改角色*/
    void updateRole(role role);
    /*删除角色*/
    void deleteRole(Long rid);
    /*查询所有角色*/
    List<role> roleList();
    /*根据id查询角色*/
    List<Long> getRoleById(Long id);
}