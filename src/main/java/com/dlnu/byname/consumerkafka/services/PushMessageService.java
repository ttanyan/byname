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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 23:32
 */
@Component
@EnableScheduling
public class PushMessageService {
    int concurrency = 20;

    private static KafkaConsumerConfig kafkaConsumerConfig;
    private static ReceiveKafkaMessage receiveKafkaMessage;

    @Autowired
    public void setKafkaConsumerConfig(KafkaConsumerConfig kafkaConsumerConfig,ReceiveKafkaMessage receiveKafkaMessage){
        PushMessageService.kafkaConsumerConfig = kafkaConsumerConfig;
        PushMessageService.receiveKafkaMessage = receiveKafkaMessage;
    }
    @Scheduled(cron = "${spring.consumer.corn}")
    public void pushMessage(){
        ExecutorService executorService = Executors.newFixedThreadPool(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executorService.submit(receiveKafkaMessage);
        }

    }

}
