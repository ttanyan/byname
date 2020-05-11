/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-05-09 9:40                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.Collection;

import java.time.LocalDateTime;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @author anyant
 * @version 1.0
 * @ClassName listDemo
 * @Description List集合测试 （有序，元素可以重复）
 * @Date 2020/5/9 8:06 下午
 */
public class CountDownTest {

    static class MyThread extends Thread {
        private CountDownLatch countDownLatch;
        private Vector<String> vector;
        private String element;

        public MyThread(CountDownLatch countDownLatch, Vector<String> vector, String element) {
            this.countDownLatch = countDownLatch;
            this.vector = vector;
            this.element = element;
        }

        @Override
        public void run() {
            super.run();

            try {
                synchronized (vector){
                    if (!vector.contains(element)) {
                        // 注意这里 线程1休息的时候这个时候还没将element添加到vector 这个时候线程2来。
                        // 线程2来的时候则也不会存在这个element元素。然后会添加两个element 相对线程安全
                        Thread.sleep(1000);
                        vector.add(element);

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Vector<String> vector = new Vector<>();

        MyThread myThread1 = new MyThread(countDownLatch, vector, "abc");
        MyThread myThread2 = new MyThread(countDownLatch, vector, "abc");

        myThread1.start();
        myThread2.start();

        //等待两个线程执行完毕
        countDownLatch.await();

        int vectorSize = vector.size();
        System.out.println("vector size: " + vectorSize);
        for (int i = 0; i < vectorSize; i++) {
            System.out.println("index " + i + ": " + vector.get(i));
        }

        //  必须提前知道有多少个线程 清楚的知道  或者知道最后一个线程是的特点，就可以将其他的消耗完.
        CountDownLatch countDownLatch1 = new CountDownLatch(3);
        Boos boos = new Boos(countDownLatch1);
        Work work = new Work(countDownLatch1,"张三");
        Work work2 = new Work(countDownLatch1,"李四");
        Work work3 = new Work(countDownLatch1,"王二");
        System.out.println(LocalDateTime.now());
        boos.start();
        work.start();
        work2.start();
        work3.start();
        System.out.println(countDownLatch1.getCount());



    }


}
