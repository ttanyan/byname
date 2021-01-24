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


package com.dlnu.byname.kafkaproducer.services;

import org.apache.kafka.clients.consumer.ConsumerRecords;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 22:38
 */
public interface MessageProcessorService {

    /**
     * 消息前置处理
     * @param value
     * @return
     */
    String beforeMessageProcessor(ConsumerRecords value);

    /**
     * 消息后置操作
     * @param value
     * @return
     */
    String afterMessageProcessor(ConsumerRecords value);
}
