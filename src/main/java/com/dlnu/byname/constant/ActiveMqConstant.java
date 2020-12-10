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


package com.dlnu.byname.constant;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/10 下午11:30
 */
public class ActiveMqConstant {
    /**
     * 告警推送订阅主题
     */
    public static final String MQ_TOPIC_WEB_SOCKET_ALARM_INFO = "topic.BYNAME.ActiveMQ.AlarmInfo";

    /**
     * 队列模式
     */
    public static final String MQ_QUEUE_WEB_ALARM_INFO = "queue.BYNAME.ActiveMQ.AlarmInfo";
}
