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
 * 2021/1/18                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.dlnu.byname.consumerkafka.services;

import com.dlnu.byname.config.kafka.KafkaConsumerConfig;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 22:47
 */
@Data
@Slf4j
@Component
public class ReceiveKafkaMessage  implements Runnable{


    private static MessageProcessorService messageProcessor;
    private static KafkaConsumerConfig kafkaConsumerConfig;

    @Autowired
    public void setResouce(MessageProcessorService messageProcessor, KafkaConsumerConfig kafkaConsumerConfig){
        ReceiveKafkaMessage.messageProcessor = messageProcessor;
        ReceiveKafkaMessage.kafkaConsumerConfig = kafkaConsumerConfig;
    }

    private static Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>(20);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaConsumerConfig.getNumbers());
//        props.put(ConsumerConfig.EXCLUDE_INTERNAL_TOPICS_CONFIG,kafkaConsumerConfig.getTopic());
        return props;
    }

    @Override
    public void run() {
        Consumer consumer = new KafkaConsumer(consumerProperties());
//        consumer.subscribe();
        ConsumerRecords consumerRecord =  consumer.poll(Duration.ofMillis(1));
        Iterator iterator = consumerRecord.iterator();

        while (iterator.hasNext()){
            ConsumerRecord record = (ConsumerRecord)iterator.next();

            String value = (String) record.value();
            value = messageProcessor.beforeMessageProcessor(value);
            log.info("kafka接收消息"+value);

        }
    }

}
