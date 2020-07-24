package com.dj.web;

import com.dj.domain.AjaxRes;
import com.dj.domain.PageListRes;
import com.dj.domain.QueryVo;
import com.dj.domain.employee;
import com.dj.service.employeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    employeeService service;

    @RequestMapping("/employee")
    @RequiresPermissions("employee:index")
    public String employee(){
        return "employee";
    }

    /*查询所有员工*/
    @RequestMapping("/emploeeList")
    @ResponseBody
    public PageListRes emploeeList(QueryVo vo){
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
            e.printStackTrace();
           return new AjaxRes(false,"保存失败");
       }
    }
    /*修改员工*/
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
    /*修改状态*/
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


    @ExceptionHandler(AuthorizationException.class)
    public void handlerShiroException(HandlerMethod method, HttpServletResponse servletResponse) throws IOException {
        /*判断当前是不是json请求*/
        ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
        if(responseBody!=null){
            servletResponse.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
            AjaxRes ajaxRes = new AjaxRes(true, "没有权限");
            String asString = new ObjectMapper().writeValueAsString(ajaxRes);
            servletResponse.getWriter().print(asString);
        }else {
            servletResponse.sendRedirect("nopermission.jsp");
        }
    }

}
