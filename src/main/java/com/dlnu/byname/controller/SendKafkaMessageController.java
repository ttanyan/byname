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


package com.dlnu.byname.controller;

import com.dlnu.byname.config.kafka.KafkaConsumerConfig;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 23:46
 */
@Slf4j
@Controller
@RequestMapping("/sendKafkaMessage")
public class SendKafkaMessageController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Resource
    private KafkaConsumerConfig kafkaConsumerConfig;

    @RequestMapping("/message")
    public String  send(String message){
        kafkaTemplate.send(kafkaConsumerConfig.getTopic(), message);
        log.info("kafka消息发送 {}",message);
        return "hehe";
    }
}
