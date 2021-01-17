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


package com.dlnu.byname.config.activemq;

import com.dlnu.byname.constant.ActiveMqConstant;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/10 下午4:02
 */
@Configuration
@EnableJms
public class JmsConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.user}")
    private String userName;
    @Value("${spring.activemq.password}")
    private String password;


    /**
     * ActiveMQ连接工厂，非@Bean创建，配置互不影响
     * @return org.apache.activemq.ActiveMQConnectionFactory
     */
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        factory.setUserName(userName);
        factory.setPassword(password);
        // 重发策略
        RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
        // 初始重发延迟时间
        queuePolicy.setInitialRedeliveryDelay(0);
        // 重发延迟时间，当initialRedeliveryDelay=0时生效
        queuePolicy.setRedeliveryDelay(1000);
        // 启用指数倍数递增的方式增加延迟时间
        queuePolicy.setUseExponentialBackOff(false);
        // 重发次数
        queuePolicy.setMaximumRedeliveries(3);
        factory.setRedeliveryPolicy(queuePolicy);
        return factory;
    }

    /**
     * 消费者策略
     * @return org.apache.activemq.ActiveMQPrefetchPolicy
     */
    @Bean
    ActiveMQPrefetchPolicy prefetchPolicy() {
        ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
        prefetchPolicy.setQueuePrefetch(1);
        prefetchPolicy.setQueueBrowserPrefetch(1);
        prefetchPolicy.setDurableTopicPrefetch(100);
        prefetchPolicy.setTopicPrefetch(32766);
        return prefetchPolicy;
    }

    /**
     * 处理topic类型工厂，只有一个消费者<br/>
     * 示例：@JmsListener(destination = "queue.TEST", containerFactory="topicListenerFactory")
     * @return org.springframework.jms.config.DefaultJmsListenerContainerFactory
     */
    @Bean(name = "topicListenerFactory")
    public DefaultJmsListenerContainerFactory topicListenerFactory(ActiveMQPrefetchPolicy prefetchPolicy) {
        ActiveMQConnectionFactory connectionFactory = connectionFactory();
        connectionFactory.setPrefetchPolicy(prefetchPolicy);
        // 使用缓存工厂连接
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(new CachingConnectionFactory(connectionFactory));
        factory.setPubSubDomain(true);
        // 消费者数量
        factory.setConcurrency("20");
        return factory;
    }

    /**
     * 处理queue类型工厂<br/>
     * 示例：@JmsListener(destination = "queue.TEST", containerFactory="queueListenerFactory", concurrency = "1-50")
     * @return org.springframework.jms.config.DefaultJmsListenerContainerFactory
     */
    @Bean(name = "queueListenerFactory")
    public DefaultJmsListenerContainerFactory queueListenerFactory(ActiveMQPrefetchPolicy prefetchPolicy) {
        ActiveMQConnectionFactory connectionFactory = connectionFactory();
        connectionFactory.setPrefetchPolicy(prefetchPolicy);
        // 使用缓存工厂连接
        CachingConnectionFactory cacheFactory = new CachingConnectionFactory(connectionFactory);
        cacheFactory.setSessionCacheSize(200);
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(cacheFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * jmsTemplate用于消息发送
     * @return org.springframework.jms.core.JmsTemplate
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        ActiveMQConnectionFactory connectionFactory = connectionFactory();
        // 启用优化ACK选项
        connectionFactory.setOptimizeAcknowledge(true);
        // 启用异步发送，非持久化默认异步
        connectionFactory.setUseAsyncSend(true);
        // 启用消息体的压缩
        connectionFactory.setUseCompression(true);
        // 每次都等待服务器端的回执
        connectionFactory.setAlwaysSyncSend(false);

        CachingConnectionFactory cacheFactory = new CachingConnectionFactory(connectionFactory);
        cacheFactory.setSessionCacheSize(100);
        JmsTemplate jmsTemplate = new JmsTemplate(cacheFactory);
        // 消息持久化
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        return jmsTemplate;
    }

    @Bean
    public Topic topic() {
        //发布订阅模式
        return new ActiveMQTopic(ActiveMqConstant.MQ_TOPIC_WEB_SOCKET_ALARM_INFO);
    }

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(ActiveMqConstant.MQ_QUEUE_WEB_ALARM_INFO);
    }
}
