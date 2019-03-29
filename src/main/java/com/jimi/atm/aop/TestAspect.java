/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年12月19日    TanLianWang         Create the class
 * http://www.jimilab.com/
*/

package com.jimi.atm.aop;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.regex.Matcher;


/**
 * @FileName TestAspect.java
 * @Description: 
 *
 * @Date 2018年12月19日 上午11:44:39
 * @author TanLianWang
 * @version 1.0
 */
@Aspect
@Component
public class TestAspect {

    /**
         * 切到Controller层  匹配HelloController下的所有带有（add的公共方法名 ）并且带有(自定义注解的方法)
     */
    @Pointcut("execution(* com.jimi.atm.controller.AdminController.*(..)) && @annotation(com.jimi.atm.aop" +
            ".MyAnnotation)")
   
    public void addAdvice(){

    }  
    //环绕通知
    @Around("addAdvice()")
    public Object InterCeptor(ProceedingJoinPoint pJoinPoint){
        //返回结果
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Object result = null; 
        //ProceedingJoinPoint 获取切点方法的参数对象，将值传入进来，以数组的形式保存
        Object[] args = pJoinPoint.getArgs();
        for(int i=0;i<args.length;i++) {
            System.out.println(args[i]);
        }
        String phone = (String) args[2];
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            request.getSession().setAttribute("registMessage", "请输入正确的手机号码");
            return "regist";
        } 
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phone);
            boolean isMatch = matcher.matches();
            
            if (!isMatch) {
                request.getSession().setAttribute("registMessage", "请输入正确的手机号码");
                return "regist";
            }try {

            //执行调用目标方法。否则目标方法本身的执行就会被跳过
            result =pJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }  
        return result;
    }
}