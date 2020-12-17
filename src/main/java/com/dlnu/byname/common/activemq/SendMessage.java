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
 * 2020/12/10    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.common.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/10 下午11:50
 */
@Slf4j
@Component
public class SendMessage {

    @Resource
    private Topic topic;
    @Resource
    private Queue queue;
    @Resource
    JmsTemplate jmsTemplate;

    public void sendTopic(String message){
        MessageCreator messageCreator = session -> {
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("content", message);
            return mapMessage; };
        jmsTemplate.send(topic,messageCreator);

        log.info("============Topic消息推送成功"+message+"=================");
    }

    public void sendQueue(String message){
        jmsTemplate.convertAndSend(queue,message);
        log.info("============Queue消息推送成功"+message+"=================");
    }

}
