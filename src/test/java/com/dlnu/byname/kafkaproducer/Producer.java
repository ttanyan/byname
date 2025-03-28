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


package com.dlnu.byname.kafkaproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/25 01:20
 */
public class Producer {


    public static void main(String[] args) {
        Properties kafkaProperties = new Properties();
        //配置broker地址，配置多个容错
        kafkaProperties.put("bootstrap.servers", "127.0.0.1:9092");
        //配置key-value允许使用参数化类型
        kafkaProperties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProperties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(kafkaProperties);
        int sum = 0;
        while (sum<100){
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("hello","hello world"+sum);
            kafkaProducer.send(record);
            sum++;
        }

    }
}
