package com.serket.cloud.interceptor;

import com.serket.cloud.bean.Log;
import com.serket.cloud.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Administrator on 2015/5/10.
 */
public class LogsInterceptor implements HandlerInterceptor
{
    @Autowired
    private
    LogService logService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url=httpServletRequest.getRequestURI();
        if(url.endsWith(".js")||url.endsWith(".css")){
            return true;
        }
        String ip= httpServletRequest.getRemoteAddr();
        Timestamp accessDate=new Timestamp(System.currentTimeMillis());
        Log log= new Log();
        log.setId(UUID.randomUUID().toString());
        log.setIp(ip);
        log.setAccessDate(accessDate);
        log.setUrl(url);

        logService.save(log);
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(e);
    }
}
