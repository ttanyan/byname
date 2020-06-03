/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-04-29 10:56                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname;

import com.dlnu.byname.common.RedisKey;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author TanLianWang
 * @version 1.0
 * @date 2020/4/29 10:56
 */
public class RedisTest extends BaseTest {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void StringRedisTest() {
        //设置键值对
        stringRedisTemplate.opsForValue().set(RedisKey.UserToken.USER_NAME + 1, "123");

        //删除缓存
        stringRedisTemplate.delete("key");

        //取值然后设置值
        String keyValue1 = stringRedisTemplate.opsForValue().getAndSet(RedisKey.UserToken.USER_NAME + 1, "1243564645645");
        System.out.println(keyValue1);

        //根据键获取值
        String keyValue = stringRedisTemplate.opsForValue().get(RedisKey.UserToken.USER_NAME + 1);
        System.out.println(keyValue);

        //判断key是否存在
        Boolean hasKey = stringRedisTemplate.hasKey("key");
        System.out.println(hasKey);

        //设置过期时间
        stringRedisTemplate.opsForValue().set(RedisKey.UserToken.USER_NAME + 2, "123213", 10, TimeUnit.SECONDS);

        //数量+1
        stringRedisTemplate.opsForValue().increment(RedisKey.UserToken.USER_NAME + 1);

        //数量-1
        stringRedisTemplate.opsForValue().decrement(RedisKey.UserToken.USER_NAME + 1);


        //根据key获取过期时间换算成指定单位
        stringRedisTemplate.getExpire(RedisKey.UserToken.USER_NAME + 2, TimeUnit.MINUTES);


    }

    @Test
    public void HashRedisTest() {
//        stringRedisTemplate
    }

    @Test
    public void ListRedisTest() {

    }

    @Test
    public void SetRedisTest() {

        //存set
        stringRedisTemplate.opsForSet().add("213", "1", "2", "3", "1");

        //获取set
        Set<String> stringSet = stringRedisTemplate.opsForSet().members("213");
        stringSet.forEach((v) -> {
            System.out.println(v);
        });
        //设置过期时间
        stringRedisTemplate.expire("213",1000,TimeUnit.SECONDS);

        //获取过期时间
        Long expire = stringRedisTemplate.getExpire("213");
        System.out.println(expire);
        //判断指定值是否在集合中
        Boolean hasKey = stringRedisTemplate.opsForSet().isMember("213","1");
        System.out.println(hasKey);
    }


    @Test
    public void ZsetRedisTest() {


    }
}
