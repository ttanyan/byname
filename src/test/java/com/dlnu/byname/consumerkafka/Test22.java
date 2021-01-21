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


package com.dlnu.byname.consumerkafka;

import com.dlnu.byname.util.MessageProcessor;
import com.dlnu.byname.util.SpringContextUtils;
import lombok.Data;
import org.apache.kafka.clients.consumer.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 00:53
 */
public class Test22 {
    @Resource
    KafkaConf kafkaConf;
    public static void main(String[] args) {

        int concurrency = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(concurrency);
        for (int i = 0; i < concurrency; i++) {
            KafkaConf conf = new KafkaConf();
            conf.setThreadId(i);
            conf.setCron("");
            conf.setStartCont(true);
            //判断是否需要执行任务定时执行 周期 条数 以及是否启用
            executorService.submit(new kafkaThread(conf));
        }
    }

    /**
     * kafka 通用配置
     */
    public static class KafkaCommonConf{

    }

    /**
     * kafka 线程配置信息
     */
    @Data
    public static class KafkaConf extends KafkaCommonConf{
        //线程id
        private Integer threadId;
        //cron表达式
        private String cron;
        //是否启用
        private boolean startCont;
        //消息处理id
        private String messageProcessorBeanId;
        //自定义topic
        private String topic;
    }

    /**
     * kafka 消息消费线程
     */
    @Data
    public static class kafkaThread implements Runnable{
        private KafkaConf conf;

        public kafkaThread(KafkaConf conf) {
            this.conf = conf;
        }

        @Override
        public void run() {
            //构造配置信息，启动当前线程包含的消费者
            Map<String, Object> confMap = new HashMap<>(4);
            confMap.put("topic", conf.getTopic());
            confMap.put(ConsumerConfig.EXCLUDE_INTERNAL_TOPICS_CONFIG,conf.getTopic());
            //一次推送多少条数据
            confMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,conf.getTopic());
            Consumer consumer = new KafkaConsumer(confMap);
            //根据id获取Bean
            MessageProcessor messageProcessor = (MessageProcessor) SpringContextUtils.getBean(conf.getMessageProcessorBeanId(), MessageProcessor.class);
            while (true){
                try {
                    messagePush(consumer, messageProcessor);
                }catch (Throwable e){

                }
            }
        }


        private void messagePush(Consumer consumer, MessageProcessor messageProcessor) {
            ConsumerRecords records = consumer.poll(Duration.ofSeconds(10));

            Iterator iterator = records.iterator();
            while (iterator.hasNext()){
                ConsumerRecord record = (ConsumerRecord)iterator.next();
                String value = (String) record.value();
                //消息前置处理器
                if (messageProcessor != null){
                    value = messageProcessor.beforeProcess(value);
                }

                //消息格式转换

                //消息后置处理器
                if (messageProcessor != null){
                    value = messageProcessor.afterProcess(value);
                }

                //消息推送
            }
        }
    }
}
