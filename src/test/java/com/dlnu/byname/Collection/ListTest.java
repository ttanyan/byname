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
 * 2020/5/10    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/10 10:31 上午
 */
public class ListTest {

    public static void main(String[] args) {
        /**
         * 1.ArrayList集合：
         * 1）底层数据结构是数组，查找快，增删慢。
         * 2） 线程不安全，效率高
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
//        for (int i = 0; i < 10; i++) {
//            list.remove(1); //将后面的所有元素移除了 抛出下标越界异常
//            return;
//        }
        /**
         * 2.Vector集合：
         * 1） 底层数据结构是数组，查询快，增删慢
         * 2）线程安全，效率低
         */
        Vector<Object> vector1 = new Vector<>();
        for (int i = 0; i < 2; i++) {
            vector1.add(i);
        }
        for (int i = 0; i < vector1.size(); i++) {
            System.out.println(vector1.get(i));
        }

        /**
         * 3.LinkedList集合：
         * 1） 底层数据结构是链表，查询慢，增删快
         * 2）线程不安全，效率高
         */
        LinkedList<Object> link = new LinkedList<>();
        link.add("你好");
        System.out.println(link.get(0));
    }


}


