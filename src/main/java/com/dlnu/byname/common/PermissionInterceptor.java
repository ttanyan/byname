package com.dlnu.byname.common;

import com.alibaba.fastjson.JSON;
import com.dlnu.byname.constant.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/9 13:20
 */
//@Component
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {


    @Autowired
    StringRedisTemplate redis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();
        String token = request.getParameter("authToken");
        //获取token
        if ((StringUtils.isNotEmpty(token)))
        {
            Cookie cookie = new Cookie("authToken",token);
            cookie.setPath("/");
            response.addCookie(cookie);
        }else {
            Cookie[] cookies = request.getCookies();
            if (cookies!=null&&cookies.length>0) {
                // token 来源未知
                Cookie cookie = Arrays.stream(cookies).filter(p -> p.getName().equals("authToken")).findAny().orElse(null);
                token = cookie == null ? token : cookie.getValue();
            }
        }

        String requestUrl;
        requestUrl = request.getScheme() +"://" + request.getServerName()
                + ":" +request.getServerPort()
                + request.getServletPath();
        if (request.getQueryString() != null){
            requestUrl += "?" + request.getQueryString();
        }
        log.debug("请求路径："+requestUrl);
        //验证是否需要授权
        if(handler instanceof HandlerMethod) {
            HandlerMethod h = (HandlerMethod)handler;
            Authorized authorized = h.getMethodAnnotation(Authorized.class);
            if (authorized!=null&&authorized.required()){
                //通过token在缓存中获取登录信息
                if (StringUtils.isNotEmpty(token)) {
                    String key = "Token";
                    Map<Object, Object> map = redis.opsForHash().entries(key);
                    if (map.size()>0){
                        String corpId = (String) map.get("corpId");
                        String userId = (String) map.get("userId");
                        request.setAttribute("corpId",corpId);
                        request.setAttribute("userId",userId);
                        log.debug("权限校验通过,corpId:"+corpId+",userId:"+userId);
                        return true;
                    }
                }
                //未通过权限
                response.reset();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter pw = response.getWriter();
                pw.write(JSON.toJSONString(new JsonResult<>()));
                pw.flush();
                return false;
            }
        }
        return true;
    }


}
