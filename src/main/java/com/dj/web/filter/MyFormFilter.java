package com.dj.web.filter;

import com.dj.domain.AjaxRes;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyFormFilter extends FormAuthenticationFilter {
    /*认证成功会调用*/
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        /*响应给浏览器*/
        AjaxRes ajaxRes = new AjaxRes(true, "登录成功");
        /*把对象转成json字符串*/
        String jsonString = new ObjectMapper().writeValueAsString(ajaxRes);
        response.getWriter().print(jsonString);
        return false;
    }
    /*认证失败 会调用*/
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        /*响应给浏览器*/
        if(e!=null){
            /*获取异常名称*/
            String name = e.getClass().getName();
            AjaxRes ajaxRes=null;
            if(name.equals(UnknownAccountException.class.getName())){
                /*账号不存在*/
                ajaxRes = new AjaxRes(false, "账号不存在");
            }else if(name.equals(IncorrectCredentialsException.class.getName())){
                /*密码错误*/
                 ajaxRes = new AjaxRes(false, "密码错误");
            }else {
                /*未知异常*/
                 ajaxRes = new AjaxRes(false, "未知异常");
            }
            String jsonString = null;
            try {
                jsonString = new ObjectMapper().writeValueAsString(ajaxRes);
                response.getWriter().print(jsonString);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        return false;
    }
}
