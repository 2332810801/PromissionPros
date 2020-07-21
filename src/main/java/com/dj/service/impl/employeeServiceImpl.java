package com.dj.service.impl;

import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.employee;
import com.dj.mapper.employeeMapper;
import com.dj.service.employeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service@Transactional
public class employeeServiceImpl implements employeeService {
    @Autowired
    employeeMapper mapper;
    @Override
    public PageListRes employeeQueryAll(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<employee> employees = mapper.selectAll(vo);
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);
        return pageListRes;
    }

    @Override
    public void saveEmployee(employee employee) {
        employee.setState(true);
        mapper.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(employee employee) {
        mapper.updateEmployee(employee);
    }

    @Override
    public void updateState(Integer id) {
        mapper.updateState(id);
    }
}
