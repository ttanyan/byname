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
 * 2020-04-15 9:15                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.common;

import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/4/15 9:21
 */
//@Component
@Slf4j
public class MqListener {

    /**
     *监听消息
     *
     */
    @JmsListener(destination = "MONITORING_ALARM", containerFactory = "jmsListenerContainerQueue")
    public void receive(MapMessage message) throws JMSException {
        String data = message.getString("content");
        log.info("接收到的消息:"+data);
    }
    
}
