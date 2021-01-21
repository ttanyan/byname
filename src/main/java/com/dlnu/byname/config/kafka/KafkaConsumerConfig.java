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


package com.dlnu.byname.config.kafka;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author anyant
 * @version 1.0
 * @Description kafka 配置
 * @Date 2021/1/18 21:41
 */
@Data
@Configuration
//@ConfigurationProperties(prefix = "spring.consumer")
public class KafkaConsumerConfig {

    /**
     * 获取记录的条数
     */
    @Value("${spring.consumer.numbers}")
    private String numbers;

    /**
     * 一次性最大消费
     */
//    private String maxNumbers;

    /**
     * 自定义消息处理
     */
//    private String messageProcess;

    /**
     * 是否启用
     */
//    private Boolean disabled;

    /**
     * 频率
     */
    @Value("${spring.consumer.corn}")
    private String corn;

    /**
     * topic
     */
    @Value("${spring.consumer.topic}")
    private List<String> topic;
}
