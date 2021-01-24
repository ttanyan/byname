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


package com.dlnu.byname.kafkaproducer.services.impl;

import com.dlnu.byname.kafkaproducer.services.MessageProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 22:44
 */
@Service
@Slf4j
public class MessageProcessorServiceImpl implements MessageProcessorService {

    @Override
    public String beforeMessageProcessor(ConsumerRecords value) {
        return null;
    }

    @Override
    public String afterMessageProcessor(ConsumerRecords records) {
        log.info("消费时间 {}", LocalDateTime.now());
       Iterator iterator = records.iterator();
       while (iterator.hasNext()){
           ConsumerRecord consumerRecord = (ConsumerRecord) iterator.next();
           log.info("topic {} value {} consumer {}",consumerRecord.topic(),consumerRecord.value(),consumerRecord.toString());

       }

        return null;
    }
}
