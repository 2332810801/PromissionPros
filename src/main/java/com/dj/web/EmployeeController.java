package com.dj.web;

import com.dj.domain.AjaxRes;
import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.employee;
import com.dj.service.employeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    employeeService service;

    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }

    /*查询所有员工*/
    @RequestMapping("/emploeeList")
    @ResponseBody
    public PageListRes emploeeList(QueryVo vo){
        System.out.println(vo);
        PageListRes pageListRes = service.employeeQueryAll(vo);
        return pageListRes;
    }
    /*保存员工*/
    @RequestMapping("/saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(employee employee){
       try {
           service.saveEmployee(employee);
          return new AjaxRes(true,"保存成功");
       }catch (Exception e){
           return new AjaxRes(false,"保存失败");
       }
    }
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(employee employee){
        try {
            service.updateEmployee(employee);
            return new AjaxRes(true,"更新成功");
        }catch (Exception e){
            return new AjaxRes(false,"更新失败");
        }
    }
    @RequestMapping("/updateState")
    @ResponseBody
    public AjaxRes updateState(Integer id){
        try {
            service.updateState(id);
            return new AjaxRes(true,"离职成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxRes(false,"离职失败");
        }

    }

}
