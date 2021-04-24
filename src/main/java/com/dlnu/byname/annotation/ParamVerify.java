package com.dlnu.byname.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/12 9:49
 */
//TODO 自定义注解如何实现  2021-04-25
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamVerify {
    String[] params();
}
