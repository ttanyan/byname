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
 * 2020/5/9    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.Collection;

import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/9 9:02 下午
 */
public class Boos extends Thread {
    private CountDownLatch countDownLatch;

    public Boos(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("老板正在等待所有人干完活了检查");
        countDownLatch.await();
        System.out.println(LocalDateTime.now()+"所有人都干完活了，老板开始检查");
    }
}
