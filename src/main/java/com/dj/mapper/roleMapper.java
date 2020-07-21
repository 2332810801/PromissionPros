package com.dj.mapper;

import com.dj.domain.QueryVo;
import com.dj.domain.role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface roleMapper {
    List<role> getRoles(QueryVo vo);

    void saveRole(role role);

    void saveRoleAndPermissRel(@Param("rid") Long rid, @Param("pid") Long pid);

    void deletePermissionRel(Long rid);

    void updateRole(role role);

    void deleteRole(Long rid);
}