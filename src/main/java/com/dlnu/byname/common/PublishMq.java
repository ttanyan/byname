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
 * 2020-04-14 17:30                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author TanLianWang
 * @version 1.0
 * @date 2020/4/14 17:30
 */
@Slf4j
//@Component
public class PublishMq {
    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Queue queue;

    @Resource
    private Topic topic;

    public static PublishMq publishMq;

    /**
     *
     * @param data 消息内容
     * @param type 消息类型 对应企业微信
     */
    public void queue(String data,String type) {
        MessageCreator messageCreator = session -> {
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("type", type);
            mapMessage.setString("content", data);
            mapMessage.setString("suiteId", "ww2e7b5f3c87c34c17");
            mapMessage.setString("corpId", "ww2e7b5f3c87c34c17");
            return mapMessage;
        };

            jmsTemplate.send(queue,messageCreator);
            log.info("===========================消息推送到MQ成功"+data+"==============================");
    }

    public void topic() {

        jmsTemplate.convertAndSend(topic, "topic");

    }

    @PostConstruct
    public void init() {
        publishMq = this;
        publishMq.topic = this.topic;
        publishMq.queue = this.queue;
        publishMq.jmsTemplate = this.jmsTemplate;
    }

}
