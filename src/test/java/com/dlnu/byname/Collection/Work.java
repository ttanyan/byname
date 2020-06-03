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

import java.util.concurrent.CountDownLatch;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/9 8:55 下午
 */
public class Work extends Thread {

    private CountDownLatch latch;
    private String name;

    public Work(CountDownLatch countDownLatch,String name){
        this.latch = countDownLatch;
        this.name = name;
    }


    @SneakyThrows
    public void run(){
        this.doWork();
        Thread.sleep(1000);
        System.out.println(name+"活已干完");
        latch.countDown();
        if ("王二".equals(name)){
            while ( true){
                latch.countDown();
//                latch = new CountDownLatch(0);
                System.out.println("王二还要加班干");
                if(latch.getCount() == 0){
                    return;
                }
            }

        }
    }

    private void doWork(){
        System.out.println(name+"正在干活");
    }

}
