/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
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
 * 2018/11/23    zhangduanfeng         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.util;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 集合、字典、数组工具类
 * @author zhangduanfeng
 * @version 1.0
 * @date 2018/11/23 17:36
 */
public class CollectionUtils {
    /**
     * 检查集合是否为空
     *
     * @param collection 集合
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:18
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 检查集合是否不为空
     *
     * @param collection 集合
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:18
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 检查字典是否为空
     *
     * @param map 字典
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:18
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 检查字典是否不为空
     *
     * @param map 字典
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:18
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    /**
     * 检查数组是否为空
     * @param arr 数组
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:18
     */
    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length < 1;
    }

    /**
     * 检查数组是否不为空
     * @param arr 数组
     * @return boolean
     * @author zhangduanfeng
     * @date 2019/2/18 14:19
     */
    public static boolean isNotEmpty(Object[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 连接集合内的元素，限字符串
     * @param col 字符串集合
     * @param separator 连接符
     * @author zhangduanfeng
     * @date 2017年12月26日 下午2:32:42
     */
    public static String join(Collection<String> col, String separator) {
        if (isEmpty(col)) {
            return "";
        }

        if (separator == null) {
            separator = "";
        }

        if (col.size() == 1) {
            return col.iterator().next();
        }

        StringBuilder builder = new StringBuilder();
        for (String str : col) {
            builder.append(str).append(separator);
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - separator.length(), builder.length());
        }
        return builder.toString();
    }

    /**
     * 连接数组内的元素，限字符串
     *
     * @param arr 字符串数组
     * @param separator 连接符
     * @return java.lang.String
     * @author zhangduanfeng
     * @date 2017年12月26日 下午2:33:18
     */
    public static String join(String[] arr, String separator) {
        if (isEmpty(arr)) {
            return "";
        }

        if (separator == null) {
            separator = "";
        }

        if (arr.length == 1) {
            return arr[0];
        }

        StringBuilder builder = new StringBuilder();
        for (String str : arr) {
            builder.append(str).append(separator);
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - separator.length(), builder.length());
        }
        return builder.toString();
    }

    /**
     * 将集合拆分为多个子集合，并返回子集合的集合。方法使用{@link List#subList(int, int)}。不进行深度克隆
     *
     * @param list 目标集合
     * @param limit 每个子集合的数量
     * @return java.util.List<java.util.List<T>>
     * @author zhangduanfeng
     * @date 2019/1/8 16:07
     */
    public static <T> List<List<T>> split(List<T> list, int limit) {
        List<List<T>> results = Lists.newArrayList();
        int size = list.size();
        if (limit >= size) {
            results.add(list);
            return results;
        }
        int count = (size + limit - 1) / limit;
        for (int i = 0; i < count; i++) {
            results.add(list.subList(i * limit, ((i + 1) * limit > size ? size : limit * (i + 1))));
        }
        return results;
    }

    /**
     * 集合转数组
     *
     * @param col 集合
     * @param tClass 集合元素类型class
     * @return T[]
     * @author zhangduanfeng
     * @date 2019/1/5 10:14
     */
    @SuppressWarnings("unchecked")
    public static <T, E extends T> T[] toArray(Collection<E> col, Class<T> tClass) {
        return col.toArray((T[])Array.newInstance(tClass, 0));
    }

    /**
     * 集合转数组
     *
     * @param col 集合
     * @param arr 制定数组
     * @return T[]
     * @author zhangduanfeng
     * @date 2019/1/5 10:15
     */
    public static <T, E extends T> T[] toArray(Collection<E> col, T[] arr) {
        if (isEmpty(col)) {
            return arr;
        }
        return col.toArray(arr);
    }

    /**
     * 获取两个集合的交集
     *
     * @param collection1 集合1
     * @param collection2 集合2
     * @return java.util.List&lt;T&gt;
     * @author zhangduanfeng
     * @date 2019/2/18 14:21
     */
    public static <T> List<T> intersection(Collection<T> collection1, Collection<T> collection2) {
        List<T> res = new ArrayList<>(collection1);
        res.retainAll(collection2);
        return res;
    }

    /**
     * 获取两个集合的差集
     * @param collection1 集合1
     * @param collection2 集合2
     * @return java.util.List&lt;T&gt;
     * @author zhangduanfeng
     * @date 2019/2/18 14:21
     */
    public static <T> List<T> subtract(Collection<T> collection1, Collection<T> collection2) {
        List<T> res = new ArrayList<>(collection1);
        res.removeAll(collection2);
        return res;
    }
}
