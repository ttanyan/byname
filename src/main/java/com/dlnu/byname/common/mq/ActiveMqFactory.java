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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName ActiveMqFactory.java
 * @Description: ActiveMq工厂，提供生产者、消费者，拉取数据、释放资源等
 * @Date 2017年11月21日 下午1:50:54
 */
public class ActiveMqFactory {

    private static final String CLIENT_ID = "sdk-client";
    private static ConcurrentMap<String, IProducer> producerMap = new ConcurrentHashMap<String, IProducer>();
    private static ExecutorService executors = Executors.newFixedThreadPool(500);
    private Logger logger = LoggerFactory.getLogger(ActiveMqFactory.class);
    private String url = "tcp://172.16.0.136:61616";
    private Integer wireFormatCacheSize = 2048;
    private Integer connectionTimeout = 10000;
    private Integer soTimeout = 10000;
    private String userName;
    private String password;
    private Boolean tcpNoDelay = true;
    private Boolean persistent = true;
    private boolean isRunning = false;
    private Integer sleepMillsWhenNoData = 1000; // 无消息时休眠时间
    private Integer pullMsgThreadSize = 1; // 1个消费者拉取消息的线程数
    private Integer consumerSize = 1; // 消费者数量

    public ActiveMqFactory() {

    }

    public ActiveMqFactory(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWireFormatCacheSize() {
        return wireFormatCacheSize;
    }

    public void setWireFormatCacheSize(Integer wireFormatCacheSize) {
        this.wireFormatCacheSize = wireFormatCacheSize;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(Integer soTimeout) {
        this.soTimeout = soTimeout;
    }

    public Boolean getTcpNoDelay() {
        return tcpNoDelay;
    }

    public void setTcpNoDelay(Boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPersistent() {
        return persistent;
    }

    public void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }

    public Integer getPullMsgThreadSize() {
        return pullMsgThreadSize;
    }

    public void setPullMsgThreadSize(Integer pullMsgThreadSize) {
        if (pullMsgThreadSize != null && pullMsgThreadSize > 1) {
            this.pullMsgThreadSize = pullMsgThreadSize;
        }
    }

    public Integer getConsumerSize() {
        return consumerSize;
    }

    public void setConsumerSize(Integer consumerSize) {
        if (consumerSize != null && consumerSize > 1) {
            this.consumerSize = consumerSize;
        }
    }

    /**
     * @return
     * @Title: getBrokerUrl
     * @Description: 生成BrokerUrl
     * @author yaojianping
     * @date 2017年11月23日 下午2:22:21
     */
    private String getBrokerUrl() {
        StringBuffer brokerURL = new StringBuffer();
        brokerURL.append("failover:(").append(url).append("?").append("wireFormat.cacheSize=")
                .append(this.wireFormatCacheSize).append("&connectionTimeout=").append(this.connectionTimeout)
                .append("&soTimeout=").append(this.soTimeout).append("&tcpNoDelay=").append(this.tcpNoDelay)
                .append(")");
        return brokerURL.toString();
    }

    /**
     * @param jmsMode
     *            消息类型，QUEUE/TOPIC
     * @param queueName
     *            消息队列名称
     * @return
     * @Title: createProducer
     * @Description: 创建一个生产者
     * @author yaojianping
     * @date 2017年11月23日 下午2:29:50
     */
    public IProducer createProducer(JMSMode jmsMode, String queueName) {
        return createProducer(jmsMode, queueName, getClientId(CLIENT_ID));
    }

    /**
     * @param jmsMode
     *            消息类型，QUEUE/TOPIC
     * @param queueName
     *            消息队列名称
     * @param clientId
     *            客户端ID，自定义
     * @return
     * @Title: createProducer
     * @Description: 创建一个生产者
     * @author yaojianping
     * @date 2017年11月23日 下午2:29:18
     */
    public IProducer createProducer(JMSMode jmsMode, String queueName, String clientId) {
        return getProducer(queueName, clientId, jmsMode);
    }

    /**
     * @param queueName
     *            消息队列名称
     * @param clientId
     *            客户端ID，自定义
     * @param jmsMode
     *            消息类型，QUEUE/TOPIC
     * @return
     * @Title: getProducer
     * @Description: 生成消费者对象，并缓存
     * @author yaojianping
     * @date 2017年11月23日 下午1:56:11
     */
    private IProducer getProducer(String queueName, String clientId, JMSMode jmsMode) {
        final String key = getMapKey(queueName, clientId);
        if (!producerMap.containsKey(key)) {
            synchronized (producerMap) {
                if (!producerMap.containsKey(key)) {
                    Producer producer = new Producer(getBrokerUrl(), userName, password, clientId);
                    producer.createProducer(jmsMode, queueName, this.persistent);
                    producer.addCloseProducerListener(new CloseProducerListener());
                    producerMap.put(key, producer.getProducer());
                    return producer.getProducer();
                }
            }
        }
        return producerMap.get(key);
    }

    private String getMapKey(String queueName, String clientId) {
        return queueName + clientId;
    }

    /**
     * @param clientId
     * @return
     * @Title: getClientId
     * @Description: 生成客户端ID
     * @author yaojianping
     * @date 2017年11月23日 下午1:50:59
     */
    private String getClientId(String clientId) {
        String ip = "UnknowHost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error("获取本机IP失败", e);
        }
        return clientId + "@" + ip + "-" + System.currentTimeMillis();
    }

    /**
     * @Title: stopPullMsg
     * @Description: 停止拉取消息
     * @author yaojianping
     * @date 2017年11月23日 下午1:50:20
     */
    public void stopPullMsg() {
        isRunning = false;
    }

    /**
     * 关闭生产者时的监听类
     */
    static class CloseProducerListener {
        public void removeProducer(String mapKey) {
            producerMap.remove(mapKey);
        }
    }

}
