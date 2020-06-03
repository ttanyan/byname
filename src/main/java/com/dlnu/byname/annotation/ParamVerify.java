package com.dlnu.byname.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/12 9:49
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamVerify {
    String[] params();
}
