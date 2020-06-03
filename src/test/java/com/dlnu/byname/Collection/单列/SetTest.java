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


package com.dlnu.byname.Collection.单列;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/10 11:02 上午
 */
public class SetTest {
    public static void main(String[] args) {
        /**
         * 1.Hashset集合：
         * 1） 底层数据结构是哈希表，哈希表依赖两个方法hascode ()和equals（）方法
         * 2）两个方法的执行顺序：
         * 首先判断hascode()值是否相同
         * 是：继续执行equals()方法，看其返回值
         * 是true：说明元素重复，不添加
         * 是false：就直接添加元素
         * 否：就直接添加到集合
         */
        /**
         * 不能保证元素的排列顺序，顺序有可能发生变化
         *  不是同步的
         *  集合元素可以是null,但只能放入一个null
         */

        Set hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.forEach(System.out::println);
        /**
         * TreeSet 是二差树实现的,
         * TreeSet中的数据是自动排好序的，不允许放入null值。
         */
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 7; i < 10; i++) {
            treeSet.add(i);
        }
        treeSet.add(6);
        Integer a = new Integer(0);
        treeSet.add(a);
        treeSet.forEach(System.out::println);





        /**
         *（100w级别操作，时间单位s）
         * TreeSet set: 1.0742924
         * HashSet set: 0.8865793
         * TreeSet get: 0.8117818
         * HashSet get: 0.208111921
         *
         * 我运行了几次的平均结果。
         * 设值比较：话基本时间保持一致，但是TreeSet是相对比较长，主要是因为TreeSet有个有个树比较排序的问题，所以耗时比较长，而hash的碰撞率是比较低，并且没有排序，所以相对快一点。
         *
         * 取比较：由于hash原理，碰撞率比较低说获取的值比较次数比较少，
         * 而TreeSet采用树结构，必须一次次比较下去，所耗时多一点 百万级别的treeset的比较差不多是hash的四倍

         */

    }
}
