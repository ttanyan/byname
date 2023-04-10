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

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/25 00:12
 */
@Data
//@Configuration
public class KafkaConsumerConfig {
    /**
     * 消费者topics；
     */
    @Value("${consumerTopics}")
    private String topics;
    /**
     * 一次性最大拉取数量
     */
    @Value("${consumerPollNumbers}")
    private String consumerPollNumbers;
    /**
     * 每次拉取间隔时间
     */
    @Value("${consumerDelay}")
    private Long pollDelay;
    @Value("${consumerGroupId}")
    private String groupId;
    @Value("${consumerBootstrap}")
    private String bootStrap;
    @Value("${consumerAutoOffset}")
    private String consumerAutoOffset;

}
