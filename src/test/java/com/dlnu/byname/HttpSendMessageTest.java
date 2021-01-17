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
 * 2021/1/4                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.dlnu.byname;

import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2021/1/4 23:59
 */
@Slf4j
public class HttpSendMessageTest extends BaseTest{

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void restTemplateGetTest(){
        JsonResult result = restTemplate.getForObject("http://127.0.0.1:8080/config/listUser?page=1&limit=5"
                , JsonResult.class);
        logger.info("不带参数的get请求 =={}",result.getData().toString());
    }

    @Test
    public void restTemplateGetTest1(){
        Map<String,Integer> map = new HashMap<>();
        map.put("page",1);
        map.put("limit",5);
        JsonResult<List<UserDO>> result = restTemplate.getForObject("http://127.0.0.1:8080/config/listUser"
                , JsonResult.class,map);
        logger.info("带参数的get请求 =={}",result.getData().toString());
    }


}
