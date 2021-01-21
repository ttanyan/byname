/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020/12/20    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.common.Factory;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.HashMap;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/20 下午11:48
 */
@Component
@Slf4j
public class BeanFactory implements BeanPostProcessor {

    private int i;
    HashMap<Integer,String> hashMap = new HashMap<>();

    /**
     * 实例化、依赖注入、初始化完毕时执行 将所有bean都装入其中。
     * 用途：抽象类有很多继承的时候可以写一个CODE方法以及实现类名称。然后存入HashMap实现初始化注册
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!Strings.isNullOrEmpty(beanName)){
            i++;
            hashMap.put(i,beanName);
            log.info(beanName+"：这是项目第"+i+"个Bean");
        }
        return bean;
    }

    @PreDestroy
    public void getAllBean(){
        for (int i = 0; i < hashMap.size(); i++) {

            log.info("容器销毁之前的bean"+hashMap.get(i));
        }
    }
}
