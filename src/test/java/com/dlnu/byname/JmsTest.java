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
 * 2020/12/10    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import com.dlnu.byname.config.activemq.SendMessage;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/10 下午4:27
 */
public class JmsTest extends BaseTest {

    @Resource
    SendMessage sendMessage;

    @Test
    public void queueTest(){
       sendMessage.sendQueue("amqQueue消息队列发送");

    }

    @Test
    public void topicTest(){
        sendMessage.sendTopic("amqTopic消息订阅和发布");
    }
}
