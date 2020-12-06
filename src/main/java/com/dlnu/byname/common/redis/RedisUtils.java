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
 * 2020/12/6    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/6 下午1:31
 */
@Component
public class RedisUtils extends AbstractRedisCmd {
    /**
     * {@link RedisConfig#redisCacheTemplate()}
     */
    @Autowired
    private  RedisTemplate<String,Object> redisTemplate;

    @Override
    public RedisTemplate<String, Object> getTemple() {
        return this.redisTemplate;
    }
}
