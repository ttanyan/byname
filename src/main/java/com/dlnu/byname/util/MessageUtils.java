/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
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
 * 2019/8/27    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.util;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2019/8/27 11:02
 */
@Component
public class MessageUtils {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key){
        return getMessage(key,null);
    }

    public String getMessage(String key,Object[] args){
        return getMessage(key,args,"");
    }
    public String getMessage(String key,Object[] args,String defaultMsg){
        Locale locale = LocaleContextHolder.getLocale();
        //构造英文
        Locale local = new Locale("en","US");
        return messageSource.getMessage(key,args,defaultMsg,local);
    }
}
