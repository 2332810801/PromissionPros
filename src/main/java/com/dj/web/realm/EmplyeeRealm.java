package com.dj.web.realm;

import com.dj.domain.employee;
import com.dj.service.employeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmplyeeRealm extends AuthorizingRealm {
    @Autowired
    employeeService service;
    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("来到了认证");
        String username=(String)token.getPrincipal();
        System.out.println(username);
        /*到数据中查询有没有当前用户*/
        employee employee = service.getEmployeeWithUsername(username);
        System.out.println(employee);
        if(employee==null){
            return null;
        }
        /*认证*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee,employee.getPassword(),this.getName());
        return info;
    }
    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }
}
