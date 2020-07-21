package com.dj.service.impl;

import com.dj.domain.department;
import com.dj.mapper.departmentMapper;
import com.dj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    departmentMapper mapper;
    @Override
    public List<department> getdepaterList() {
        return mapper.selectAll();
    }
}
