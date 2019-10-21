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

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName AbstractActiveMQ.java
 * @Description: ActiveMQ抽象类，提供链接工厂、会话
 * @Date 2017年11月21日 下午4:58:01
 */
public abstract class AbstractActiveMQ {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * ActiveMQ连接工厂
     */
    protected ActiveMQConnectionFactory factory;

    /**
     * 连接对象
     */
    protected Connection connection;

    /**
     * 会话对象
     */
    protected Session session;

    /**
     * 客户端ID
     */
    protected String clientId;

    /**
     * @param brokerURL
     *            ActiveMQ地址
     * @param user
     *            账号
     * @param password
     *            密码
     * @param clientId
     *            客户端编号
     * @Title: createConnection
     * @Description: 创建ActiveMQ链接
     * @author yaojianping
     * @date 2017年11月23日 下午5:47:58
     */
    protected void createConnection(final String brokerURL, String user, String password, String clientId) {
        if (null == connection) {
            this.clientId = clientId;
            logger.info("ready connect to activemq: " + brokerURL);
            factory = new ActiveMQConnectionFactory(brokerURL);
            factory.setUserName(user);
            factory.setPassword(password);
            // 重发策略
            RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
            queuePolicy.setInitialRedeliveryDelay(0);
            queuePolicy.setRedeliveryDelay(1000);// 重发延时
            queuePolicy.setUseExponentialBackOff(false);
            queuePolicy.setMaximumRedeliveries(3);// 重发次数
            factory.setRedeliveryPolicy(queuePolicy);
            // 创建连接
            try {
                connection = factory.createConnection();
                connection.setClientID(clientId);
            } catch (JMSException e) {
                logger.error("ActiveMq创建连接失败", e);
            }
        }
    }

    /**
     * @Title: createSession
     * @Description: 创建ActiveMQ会话
     * @author yaojianping
     * @date 2017年11月23日 下午5:49:39
     */
    protected void createSession() {
        if (null != connection) {
            if (null == session) {
                try {
                    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                } catch (JMSException e) {
                    logger.error("ActiveMq创建会话失败", e);
                }
            }
        } else {
            logger.error("连接为空，无法创建Session");
        }
    }

    /**
     * @Title: shutdown
     * @Description: 释放会话、连接
     * @author yaojianping
     * @date 2017年11月23日 下午5:49:50
     */
    protected void shutdown() {
        if (null != this.session) {
            try {
                this.session.close();
            } catch (JMSException e) {
                logger.error("关闭Session异常", e);
            }
        }
        if (null != this.connection) {
            try {
                this.connection.close();
            } catch (JMSException e) {
                logger.error("关闭Connect异常", e);
            }
        }
    }

    /**
     * @return
     * @Title: getClientId
     * @Description: 获取连接的客户端ID
     * @author yaojianping
     * @date 2017年11月23日 下午5:50:17
     */
    protected String getClientId() {
        return this.clientId;
    }
}
