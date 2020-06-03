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
 * 2020/5/7    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/7 11:05 下午
 */
public class Test3ImplCallable implements Callable<String> {

    private int count = 100;

    @Override
    public String call()  {
        while (true) {

            if (count > 0) {
                System.out.println("线程"+Thread.currentThread().getName()+"执行"+count--);
                return "success";
            }

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test3ImplCallable test3ImplCallable = new Test3ImplCallable();
        FutureTask<String> futureTask = new FutureTask<>(test3ImplCallable);
        Thread thread = new Thread(futureTask,"thread1");
        thread.start();
        System.out.println(futureTask.get());
    }
}
