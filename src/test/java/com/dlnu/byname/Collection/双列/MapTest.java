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


package com.dlnu.byname.Collection.双列;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/10 11:19 上午
 */
public class MapTest {

    public static void main(String[] args) {
        /**
         * HashMap TreeMap非线程安全
         * Hashtable 线程安全
         */

        /**
         * 1、HashMap
         * key不能重复，value可以重复
         */
        Map<String,String> map = new HashMap<>();
        map.put("A","上海");
        map.put("B","北京");
        map.put("C","重庆");
        map.put("D","南京");
        map.put("E","上海");

        //      1、通过内部类Entry进行遍历
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("内部entry遍历========="+entry);
        }

        //      2、通过迭代器进行遍历，先获得Entry的Set集合
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("迭代entry遍历========="+entry);
        }

        //      3、通过keySet方法获得键的Set集合，通过遍历键取值
        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            String value = map.get(key);
            System.out.println("通过迭代key遍历======="+key+"="+value);
        }

        //      4、通过map.values()获得所有值，但是不能获得键
        System.out.println(map.values());




    }

}
