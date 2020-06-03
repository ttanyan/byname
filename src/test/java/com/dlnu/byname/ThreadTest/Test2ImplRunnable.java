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

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description  实现Runnable接口创建多线程
 * @Date 2020/5/7 10:37 下午
 */
public class Test2ImplRunnable  implements Runnable{

    private  int count= 100;
    private int i = 0;

    @Override
    public void run() {
        while (true){
            if(count>0){
                if("thread1".equals(Thread.currentThread().getName())){
                    System.out.println(i++);
                }

                System.out.println("线程"+Thread.currentThread().getId()+Thread.currentThread().getName()+"执行编号"+count--);
            }
        }
    }

    public static void main(String[] args) {
        //两个线程执行同一个任务
        Test2ImplRunnable test2ImplRunnable = new Test2ImplRunnable();
        Thread thread = new Thread(test2ImplRunnable,"thread1");
        thread.start();
        Thread thread1 = new Thread(test2ImplRunnable,"thread2");
        thread1.start();
//        Thread thread2 = new Thread(test2ImplRunnable, "thread3");
//        thread2.start();

        //两个线程执行各自的任务
//        Test2ImplRunnable test2ImplRunnable1 = new Test2ImplRunnable();
//        Thread thread = new Thread(test2ImplRunnable1,"thread1");
//        thread.start();
//
//        Test2ImplRunnable test2ImplRunnable = new Test2ImplRunnable();
//        Thread thread1 = new Thread(test2ImplRunnable1,"threa2");
//        thread1.start();

    }

}
