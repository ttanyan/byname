/*
 * COPYRIGHT. AnyanT. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of AnyanT.
 * Amendment History:
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2012.12.30 00:17$                 anyant$           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.dlnu.byname.config.kafka;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description kafka配置，实际上，在KafkaAutoConfiguration中已经有默认的根据配置文件信息创建配置，但是自动配置属性没有涵盖所有.我们可以自定义创建相关bean，进行如下配置
 * @Date 2020/12/30 00:16
 */
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * 构造消费者属性map，ConsumerConfig中的可配置属性比spring boot自动配置要多
     * @return
     */
    private Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 5);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "activity-service");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return props;
    }

    /**
     * 不使用spring boot默认方式创建的DefaultKafkaConsumerFactory，重新定义创建方式
     *
     * @return
     */
    @Bean
    public DefaultKafkaConsumerFactory consumerFactory() {
        return new DefaultKafkaConsumerFactory(consumerProperties());
    }

    /**
     * 个性化定义消费者
     * @param consumerFactory
     * @return
     */
    @Bean("listenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory listenerContainerFactory(DefaultKafkaConsumerFactory consumerFactory) {
        //指定使用DefaultKafkaConsumerFactory
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        //设置消费者ack模式为手动，看需求设置
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        //设置可批量拉取消息消费，拉取数量一次3，看需求设置
        factory.setConcurrency(3);
        factory.setBatchListener(true);
        return factory;
    }

    /**
     *  代码创建方式topic
     * @return
     */
    @Bean
    public NewTopic batchTopic() {
        return new NewTopic("topic.quick.batch", 8, (short) 1);
    }

    /**
     * 创建生产者配置map，ProducerConfig中的可配置属性比spring boot自动配置要多
     * @return
     */
    private Map<String, Object> producerProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "-1");
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 5);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 500);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return props;
    }

    /**
     * 不使用spring boot的KafkaAutoConfiguration默认方式创建的DefaultKafkaProducerFactory，重新定义
     *
     * @return
     */
    @Bean("produceFactory")
    public DefaultKafkaProducerFactory produceFactory() {
        return new DefaultKafkaProducerFactory(producerProperties());
    }

    /**
     * 不使用spring boot的KafkaAutoConfiguration默认方式创建的KafkaTemplate，重新定义
     * @param produceFactory
     * @return
     */
    @Bean
    public KafkaTemplate kafkaTemplate(DefaultKafkaProducerFactory produceFactory) {
        return new KafkaTemplate(produceFactory);
    }


}
