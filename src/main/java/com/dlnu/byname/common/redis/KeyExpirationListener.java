/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020/12/4    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.common.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/4 下午4:15
 */
@Slf4j
public class KeyExpirationListener extends KeyExpirationEventMessageListener {

    /**
     * 订阅频道
     */
    private final PatternTopic TOPIC;


    public KeyExpirationListener(int dbIndex, RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
        TOPIC = new PatternTopic(String.format("keyevent@%d_:expored",dbIndex));
        log.info(TOPIC.getTopic());
    }


    @Override
    protected void doRegister(RedisMessageListenerContainer listenerContainer) {
        listenerContainer.addMessageListener(this,TOPIC);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        log.info("expiredKey========="+expiredKey);
        if(new String(pattern).equals(TOPIC.getTopic())){
            String redis = message.toString();
            log.info(redis);
        }
    }

}
