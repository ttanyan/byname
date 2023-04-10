/*
 * COPYRIGHT. AnyanT tanlianwang@qq.com
 * ALL RIGHTS RESERVED
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of AnyanT.
 * Amendment History:
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2021/1/25                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.dlnu.byname.config.kafka;

import com.dlnu.byname.kafkaproducer.services.MessageProcessorService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/25 00:26
 */
//@Configuration
public class ConsumerTask {

    @Resource
    MessageProcessorService messageProcessor;
//    @Resource
    KafkaConsumerConfig kafkaConsumerConfig;


    @Bean
    public KafkaConsumer getKafkaConsumer() {
        Properties properties = new Properties();
        //设置kafka集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerConfig.getBootStrap());
        // 设置反序列化的kv类型
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //设置消费者组的groupId
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerConfig.getGroupId());
         //设置从哪里开始消费
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaConsumerConfig.getConsumerAutoOffset());
       //设置是否自动维护offset
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        //设置单次拉去数量
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaConsumerConfig.getConsumerPollNumbers());
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        return kafkaConsumer;
    }

    @Bean
    public void ConsumerTask() {
        KafkaConsumer kafkaConsumer = getKafkaConsumer();
        List<String> list = Arrays.asList(kafkaConsumerConfig.getTopics().split(","));
        kafkaConsumer.subscribe(list);
        //设置消费间隙 单位 秒
        while (true){

        ConsumerRecords consumerRecords = kafkaConsumer.poll(kafkaConsumerConfig.getPollDelay());
        //kafka定时任务拉取数量
        messageProcessor.afterMessageProcessor(consumerRecords);
        }

    }
}
