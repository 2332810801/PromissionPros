package com.dj.service.impl;

import com.dj.domain.permission;
import com.dj.mapper.permissionMapper;
import com.dj.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class permissionServiceImpl implements permissionService {
    @Autowired
    permissionMapper mapper;
    @Override
    public List<permission> permissionList() {
        return mapper.selectAll();
    }

    @Override
    public List<permission> getPermissionById(Long rid) {
        return mapper.getPermissionById(rid);
    }
}
