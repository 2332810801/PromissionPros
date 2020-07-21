package com.dj.service.impl;

import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.permission;
import com.dj.domain.role;
import com.dj.mapper.roleMapper;
import com.dj.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private roleMapper mapper;
    @Override
    public PageListRes getRoles(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<role> roles = mapper.getRoles(vo);
        return new PageListRes(page.getTotal(),roles);
    }

    @Override
    public void saveRole(role role) {
        /*1.保存角色*/
        mapper.saveRole(role);
        /*2.保存角色相关联的关系*/
        for (permission permission : role.getPermissions()) {
            mapper.saveRoleAndPermissRel(role.getRid(),permission.getPid());
        }
    }

    @Override
    public void updateRole(role role) {
        /*打破角色和权限的关系*/
        mapper.deletePermissionRel(role.getRid());
        /*更新角色*/
        mapper.updateRole(role);
        /*重新建立关系*/
        for (permission permission : role.getPermissions()) {
            mapper.saveRoleAndPermissRel(role.getRid(),permission.getPid());
        }
    }

    @Override
    public void deleteRole(Long rid) {
        mapper.deletePermissionRel(rid);
        mapper.deleteRole(rid);
    }
}
