package com.serket.cloud.interceptor;

import com.serket.cloud.bean.Sessioninfo;
import com.serket.cloud.service.SessionService;
import com.serket.cloud.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/5/10.
 */
public class AccessTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionService service;

    // 处理前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        service.updateSessionInfo();

        //获取访问的ip
        String accessToken = request.getHeader("accessToken");
        String ip = request.getRemoteAddr();
        String v = Encryption.SHA(accessToken + ip);


//
//        PrintWriter out=null;
//        // 如果没有令牌
//        if(accessToken==null){
//            out=response.getWriter();
//            // {"state":"fail","errmsg","accessToken erro"}
//            out.write("{\"state\":\"fail\",\"errmsg\",\"accessToken erro\"}");
//            return false;
//        }
//
//        SessionInfo info = service.getSessionInfo(accessToken);
//        // 判断ip 跟accessToken是否匹配
//        if(!v.equals(info.getVerification())){
//            out.write("{\"state\":\"fail\",\"errmsg\",\"verification erro\"}");
//            return false;
//        }
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    // 处理完成
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
