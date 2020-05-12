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

package com.dlnu.byname.aspect;

import com.dlnu.byname.domain.entity.UserDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author TanLianWang
 * @version 1.0
 * @FileName TestAspect.java
 * @Description:
 * @Date 2018年12月19日 上午11:44:39
 */
@Aspect
@Component
public class LoginAspect {

    /**
     * 切到Controller层  匹配LoginController下的所有带有自定义注解的方法
     * TODO 增加切点
     */
    @Pointcut("execution(* com.dlnu.byname.controller.LoginController.*(..)) && @annotation(com.dlnu.byname." +
            "annotation.LoginVerify)")
    public void addAdvice() {

    }

    /**
     * 环绕通知 学号验证
     *
     * @author Tanlianwang
     * @version 1.0
     * @date 2019/3/30 10:23
     */
    @Around("addAdvice()")
    public Object interCaptor(ProceedingJoinPoint pJoinPoint) {
        //返回结果
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object result = null;
        String number = null;
        //得到切点参数
        Object[] object = pJoinPoint.getArgs();
        for (Object o : object) {
            if (o instanceof UserDO) {
                UserDO userDO = (UserDO) o;
                number = userDO.getNumber();
            }
        }
        String regex = "^[2-9]([0-9]){9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        boolean isMatch = matcher.matches();
        if (!isMatch) {
            request.getSession().setAttribute("registerMessage", "请检查学号输入是否正确！");
            return "register";
        }
        try {
            //执行调用目标方法。否则目标方法本身的执行就会被跳过
            result = pJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}