package com.dj.mapper;

import com.dj.domain.QueryVo;
import com.dj.domain.employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface employeeMapper {
    /*查询所有员工*/
    List<employee> selectAll(QueryVo vo);
    /*添加员工*/
    void saveEmployee(employee employee);
    /*修改员工*/
    void updateEmployee(employee employee);
    /*修改状态*/
    void updateState(Integer id);
    /*添加员工角色*/
    void saveEmployeAndrole(@Param("id") Long id, @Param("rid") Long rid);
    /*删除员工角色*/
    void deleteRoleRel(Long id);
    /*根据用户名查询用户*/
    employee getEmployeeWithUsername(String username);
}