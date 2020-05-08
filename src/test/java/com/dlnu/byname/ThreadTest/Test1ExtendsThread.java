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
 * @Description  继承Thread方法实现多线程
 * @Date 2020/5/7 9:38 下午
 */
public class Test1ExtendsThread extends Thread {

    public static void main(String[] args) {
            Test1ExtendsThread threadTest1 =new Test1ExtendsThread();
            threadTest1.start();
            //创建并启动第一个线程
            new Test1ExtendsThread().start();

            //创建并启动第二个线程
            new Test1ExtendsThread().start();

    }
    public void run(){

            System.out.println(Thread.currentThread()+"我想给你一巴掌");

    }
}
