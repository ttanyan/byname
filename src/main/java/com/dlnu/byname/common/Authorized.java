package com.dlnu.byname.common;

import java.lang.annotation.*;


/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/9 11:08
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorized {
    boolean required() default true;
}
