/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-05-12 9:58                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.aspect;

import com.dlnu.byname.annotation.ParamVerify;
import com.dlnu.byname.expetion.ParamException;
import com.dlnu.byname.util.ClassUtils;
import com.dlnu.byname.util.CollectionUtils;
import com.dlnu.byname.util.StringUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TanLianWang
 * @version 1.0
 * @date 2020/5/12 9:58
 */
@Component
@Aspect
@Slf4j
@Logger
public class ParamAspect {

    @Pointcut("execution(public * com.dlnu.byname.controller..*Controller.*(..))&&@annotation(com.dlnu.byname.annotation.ParamVerify)")
    public void cut() {
        log.info("入参");
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        MethodSignature signature = (MethodSignature) point.getSignature();
        String[] ParamNames = signature.getParameterNames();
        if (CollectionUtils.isEmpty(args)) {
            throw new ParamException("参数为空");
        }
        // 获取请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Map<String, String> params = getAllRequestParam(request);
        if (params.size() == 0 && ParamNames.length > 0) {
            throw new ParamException("请求参数缺失");
        }

        ParamVerify paramVerify = signature.getMethod().getAnnotation(ParamVerify.class);
        //注解参数
        String[] requiredFields = paramVerify.params();
        boolean vParams = validParams(params, requiredFields);
        if (vParams) {
            return point.proceed(args);
        }
        throw new ParamException("参数缺失或格式错误");

    }

    /**
     * 获取请求参数
     */
    //TODO 传入为类的时候无法验证参数
    public static Map<String, String> getAllRequestParam(HttpServletRequest request) {
        Map<String, String> res = new HashMap<>(16);
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (StringUtils.isEmpty(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

    /**
     * 校验传入参数params（非null）中是否必含requiredFields（非null）中的各个属性，且属性值非空
     *
     * @param params         传入参数
     * @param requiredFields 设置的非空属性数组
     * @return 校验通过返回true，否则返回false
     */
    private Boolean validParams(Map<String, String> params, String[] requiredFields) {
        if (requiredFields.length != 0) {
//            //参数
//            if(params.size()==0){
//                return false;
//            }
            for (String field : requiredFields) {
                if (StringUtils.isEmpty(params.get(field))) {
                    return false;
                }
            }
        }
        return true;
    }
}


// 参数值 Object[] args = point.getArgs();
//        System.out.println("test signature");
//        System.out.println("方法"+signature.getMethod());
//        System.out.println("返回类型"+signature.getReturnType());
//        System.out.println("方法名"+signature.getName());
//        System.out.println("方法参数名"+signature.getParameterNames().toString());
//        System.out.println("方法参数类型"+signature.getParameterTypes().toString());