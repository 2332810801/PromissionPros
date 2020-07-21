package com.dj.mapper;

import com.dj.domain.QueryVo;
import com.dj.domain.employee;

import java.util.List;

public interface employeeMapper {

    List<employee> selectAll(QueryVo vo);

    void saveEmployee(employee employee);

    void updateEmployee(employee employee);

    void updateState(Integer id);
}