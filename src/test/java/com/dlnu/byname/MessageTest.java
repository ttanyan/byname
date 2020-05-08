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


package com.dlnu.byname;

import com.dlnu.byname.util.MessageUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;


/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2019/8/27 9:30
 */
public class MessageTest extends BaseTest {
    @Autowired
    MessageSource messageSource;
    @Autowired
    MessageUtils messageUtils;


    @Test
    public void MessageOutTest(){
        //默认语言
        logger.info(messageSource.getMessage("hello",null,"", null));
        logger.info(messageUtils.getMessage("et"));
        logger.info(LocaleContextHolder.getLocale().toString());
        Locale[] ls = Locale.getAvailableLocales();

        for (Locale locale:ls) {
            System.out.println("locale :"+locale);
        }


    }




}
