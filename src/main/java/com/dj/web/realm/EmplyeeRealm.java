package com.dj.web.realm;

import com.dj.domain.employee;
import com.dj.service.employeeService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmplyeeRealm extends AuthorizingRealm {
    @Autowired
    employeeService service;
    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();
        /*到数据中查询有没有当前用户*/
        employee employee = service.getEmployeeWithUsername(username);
        if(employee==null){
            return null;
        }
        /*认证*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee,employee.getPassword(), ByteSource.Util.bytes("Joker-DJ"),this.getName());
        return info;
    }
        /*授权*/
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
            System.out.println("来到了授权");
            employee employee = (employee)principal.getPrimaryPrincipal();
            List<String> roles=service.getroleById(employee.getId());

            List<String> permission=service.getpermission(employee.getId());
            if(employee.getAdmin()){
                /*拥有所有的权限*/
                permission.add("*:*");
            }
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(roles);
            info.addStringPermissions(permission);
            return info;
        }
}
