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
 * 2017年11月21日    yaojianping         Create the class
 * http://www.jimilab.com/
 */

package com.dlnu.byname.common.mq;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName IProducer.java
 * @Description: 生产者接口，提供消息发送、关闭连接
 * @Date 2017年11月21日 下午6:11:59
 */
public interface IProducer {

    /**
     * @param msg
     *            字节数组
     * @return
     * @Title: sendMsg
     * @Description: 按字节数组发送消息
     * @author yaojianping
     * @date 2017年11月22日 上午9:51:15
     */
    boolean sendMsg(byte[] msg);

    /**
     * @param msg
     *            字符文本
     * @return
     * @Title: sendMsg
     * @Description: 按字符串文本发送消息
     * @author yaojianping
     * @date 2017年11月22日 上午9:51:53
     */
    boolean sendMsg(String msg);

    /**
     * @Title: closeClient
     * @Description: 关闭当前建立的连接，释放资源
     * @author yaojianping
     * @date 2017年11月22日 上午9:52:20
     */
    void closeClient();
}
