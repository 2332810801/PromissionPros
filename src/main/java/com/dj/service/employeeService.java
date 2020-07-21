package com.dj.service;

import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.employee;

public interface employeeService {
    /*查询员工的方法*/
    public PageListRes employeeQueryAll(QueryVo vo);
    /*添加员工的方法*/
    public void saveEmployee(employee employee);
    /*修改员工的方法*/
    void updateEmployee(employee employee);
    /*修改离职状态*/
    void updateState(Integer id);
}
