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
 * 2017年11月22日    yaojianping         Create the class
 * http://www.jimilab.com/
 */

package com.dlnu.byname.common.mq;

/**
 * @author yaojianping
 * @version 1.0
 * @FileName MessageListener.java
 * @Description: 消费者消息监听接口，用户自己实现
 * @Date 2017年11月22日 上午10:01:22
 */
public interface MessageListener {

    /**
     * @param msg
     *            字节数组消息
     * @return
     * @Title: dealMsg
     * @Description: 处理字节数组消息
     * @author yaojianping
     * @date 2017年11月22日 下午8:43:22
     */
    boolean dealMsg(byte[] msg);

    /**
     * @param msg
     *            字符文本消息
     * @return
     * @Title: dealMsg
     * @Description: 处理字符文本消息
     * @author yaojianping
     * @date 2017年11月22日 下午8:43:38
     */
    boolean dealMsg(String msg);
}
