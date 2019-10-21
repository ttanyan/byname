/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2017.
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
 * 2017年11月21日    yaojianping         Create the class
 * http://www.jimilab.com/
 */

package com.dlnu.byname.common.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dlnu.byname.common.mq.ActiveMqFactory.*;
import javax.jms.*;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName Producer.java
 * @Description: ActiveMQ生产者，提供生产者一些操作
 * @Date 2017年11月21日 下午3:23:40
 */
public class Producer extends AbstractActiveMQ implements IProducer {

    private Logger logger = LoggerFactory.getLogger(Producer.class);

    /**
     * 消息生产者
     */
    private MessageProducer producer;

    /**
     * 生产者名称
     */
    private String myTarget;

    /**
     * 生产者关闭后监听类
     */
    private CloseProducerListener closeProducerListener;

    /**
     * 构造函数
     */
    public Producer(String brokerURL, String user, String password, String clientId) {
        createConnection(brokerURL, user, password, clientId);
        createSession();
    }

    /**
     * @return
     * @Title: getProducer
     * @Description: 获取生产者
     * @author yaojianping
     * @date 2017年11月23日 下午6:03:13
     */
    public IProducer getProducer() {
        return this;
    }

    /**
     * @param jmsMode
     *            消息类型，QUEUE/TOPIC
     * @param target
     *            目标队列名称
     * @param persistent
     *            持久化标识
     * @Title: createProducer
     * @Description: 创建生产者
     * @author yaojianping
     * @date 2017年11月23日 下午6:04:09
     */
    public void createProducer(JMSMode jmsMode, String target, boolean persistent) {
        this.myTarget = target;
        if (null == session) {
            logger.error("session 为空创建生产者失败");
            return;
        }
        try {
            Destination dest = null;
            switch (jmsMode) {
            case TOPIC:
                dest = session.createTopic(target);
                break;
            case QUEUE:
                dest = session.createQueue(target);
                break;
            }
            this.producer = session.createProducer(dest);
            // 持久化
            if (persistent) {
                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            }
        } catch (JMSException e) {
            logger.error(this.myTarget + "创建失败", e);
        }
    }

    /**
     * @param closeProducerListener
     * @Title: addCloseProducerListener
     * @Description: 设置关闭生产者回调监听
     * @author yaojianping
     * @date 2017年11月23日 下午6:06:02
     */
    public void addCloseProducerListener(CloseProducerListener closeProducerListener) {
        this.closeProducerListener = closeProducerListener;
    }

    /**
     * 发送消息
     *
     * @param data
     * @return
     */
    @Override
    public boolean sendMsg(byte[] data) {
        boolean success = false;
        // 如果有生产者
        if (null != this.producer) {
            try {
                BytesMessage msg = session.createBytesMessage();
                msg.writeBytes(data);
                this.producer.send(msg);
                success = true;
            } catch (Exception e) {
                logger.error(this.myTarget + "发送消息失败", e);
            }
        } else {
            logger.error("producer为空，请先创建生产者!");
        }
        return success;
    }

    /**
     * 发送消息
     *
     * @param msg
     * @return
     */
    @Override
    public boolean sendMsg(String msg) {
        boolean success = false;
        // 如果有生产者
        if (null != this.producer) {
            try {
                TextMessage textMessage = session.createTextMessage(msg);
                this.producer.send(textMessage);
                success = true;
            } catch (Exception e) {
                logger.error(this.myTarget + "发送消息失败", e);
            }
        } else {
            logger.error("producer为空，请先创建生产者!");
        }

        return success;
    }

    /**
     * 关闭生产者通道
     */
    @Override
    public void closeClient() {
        if (null != this.producer) {
            try {
                this.producer.close();
            } catch (JMSException e) {
                logger.error(this.myTarget + "关闭失败", e);
            }
        }
        super.shutdown();

        if (null != closeProducerListener) {
            final String mapKey = myTarget + clientId;
            closeProducerListener.removeProducer(mapKey);
        }
    }
}
