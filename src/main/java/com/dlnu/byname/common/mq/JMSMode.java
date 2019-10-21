/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2017.
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
 * 2017年11月20日    yaojianping         Create the class
 * http://www.jimilab.com/
 */

package com.dlnu.byname.common.mq;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName JMSMode.java
 * @Description: JMS类型枚举
 * @Date 2017年11月20日 下午6:31:01
 */
public enum JMSMode {

    TOPIC("topic"), QUEUE("queue");

    String name;

    JMSMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
