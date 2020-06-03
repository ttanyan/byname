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
 * 2020-05-12 14:30                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.handler;

import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.expetion.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/12 14:30
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handler(Exception e){
        //方法未声明异常时抛出UndeclaredThrowableException  Cause 获取异常类型
        if (e instanceof UndeclaredThrowableException){
            e = (Exception) e.getCause();
        }
        if(e instanceof ParamException){
            return new JsonResult("参数错误");
        }else{
            log.error("exception:{}", e.getMessage(), e);
            return new JsonResult("请求失败");
        }

    }
}
