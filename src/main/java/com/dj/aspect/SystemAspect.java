package com.dj.aspect;

import com.dj.domain.systemlog;
import com.dj.util.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class SystemAspect {
    public void writeLog(){
        systemlog systemlog = new systemlog();
        /*设置时间*/
        systemlog.setOptime(new Date());
        /*设置ip地址 request 添加拦截器 */
        HttpServletRequest request = RequestUtil.getRequest();
        if(request!=null){
            String ip = request.getRemoteAddr();
            systemlog.setIp(ip);
        }

    }
}
