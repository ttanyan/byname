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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/4 下午2:20
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Resource
    private LettuceConnectionFactory redisConnectionFactory;

    @Value("${spring.redis.database}")
    int dbIndex;

    /**
     * Object序列化模版
     * @return objectTemplate
     */
    @Bean
    public RedisTemplate<String,Object> redisCacheTemplate(){
        //redisValue 序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //RedisKey 序列化
        RedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //redis桶设置
        redisConnectionFactory.setDatabase(dbIndex);
        RedisTemplate<String,Object> objectRedisTemplate = new RedisTemplate<>();
        objectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        objectRedisTemplate.setKeySerializer(stringRedisSerializer);
        objectRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        objectRedisTemplate.setHashKeySerializer(stringRedisSerializer);
        objectRedisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    //初始化redisTemplate
        objectRedisTemplate.afterPropertiesSet();
        return objectRedisTemplate;
}

    /**
     * String 序列化模版
     * @return stringTemplate
     */
    @Bean("stringRedisCacheTemplate")
    public StringRedisTemplate stringRedisCacheTemplate(){
        redisConnectionFactory.setDatabase(dbIndex);
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        //字符串序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        stringRedisTemplate.setKeySerializer(stringRedisSerializer);
        stringRedisTemplate.setValueSerializer(stringRedisSerializer);
        stringRedisTemplate.setHashKeySerializer(stringRedisSerializer);
        stringRedisTemplate.setHashValueSerializer(stringRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }

    /**
     * 缓存key生成策略 项目名+类名+方法名+参数
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return (target,method,params)->{
            StringBuilder stringBuilder = new StringBuilder("ByName:");
            stringBuilder.append(target.getClass().getSimpleName()).append(".");
            stringBuilder.append(method.getName());
            for(Object param : params){
                stringBuilder.append(param);
            }
            return stringBuilder.toString();
        };
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return super.errorHandler();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListener(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    @Bean
    KeyExpirationListener keyExpirationListener(){
        return new KeyExpirationListener(dbIndex, redisMessageListener());
    }


}
