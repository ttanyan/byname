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


package com.dlnu.byname.Redis;

import com.dlnu.byname.BaseTest;
import com.dlnu.byname.config.redis.RedisUtils;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/6 下午2:20
 */
public class RedisTest extends BaseTest {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void IncrTest() {
        //线程池执行
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                //key递增
                executorService.execute(() -> redisUtils.incr("kk", 1))
        );
        logger.info(redisUtils.get("kk").toString());
    }

    @Test
    public void SetExpireTest() throws InterruptedException {
        redisUtils.set("expire", "123", 8);
        TimeUnit.SECONDS.sleep(3);
        logger.info("key剩余过期时间" + redisUtils.getExpire("expire"));
    }

    @Test
    public void deleteKey() {
        if(redisUtils.delete("23123123") == true){
            logger.info("key 异常");
        }
        redisUtils.delete("kk");
        logger.info("delete kk OK");
    }


}
