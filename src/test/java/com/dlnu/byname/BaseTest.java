/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
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
 * 2018/12/26    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 14:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ByNameApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void init() {
    }

    @After
    public void after() {
        System.out.println("===================Test End"+LocalDateTime.now()+"===================");
    }

}
