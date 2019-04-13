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
 * 2018/11/23    TanLianWang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.util;

import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 断言类，抛出各种异常。
 * @author TanLianWang
 * @version 1.0
 * @date 2018/11/23 17:27
 */
public class Assert {
    /**
     * 当表达式为false时，抛出{@link IllegalStateException}异常
     *
     * @param expression 表达式
     * @param message    自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:56
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * 当表达式为false时，抛出{@link IllegalArgumentException}异常
     *
     * @param expression 表达式
     * @param message    自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:57
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 当object不等于null时，抛出{@link IllegalArgumentException}异常
     *
     * @param object  对象
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:57
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 当object等于null时，抛出{@link IllegalArgumentException}异常
     *
     * @param object 对象
     * @author TanLianWang
     * @date 2019/2/18 13:58
     */
    public static void notNull(Object object) {
        notNull(object, "\"object\" must not be null");
    }

    /**
     * 当object等于null时，抛出{@link IllegalArgumentException}异常
     *
     * @param object  对象
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:59
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 当字符串为空时（长度大于0），抛出{@link IllegalArgumentException}异常
     *
     * @param text    字符串
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:59
     */
    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }


    /**
     * 当字符串无任何文本时（空格、tab键、换行符等空白符会被作为无文本处理），抛出{@link IllegalArgumentException}异常
     *
     * @param text    字符串
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 13:59
     */
    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 文本textToSearch中不包含substring时，抛出{@link IllegalArgumentException}异常
     *
     * @param textToSearch 需要被搜索的字符串
     * @param substring    子串
     * @param message      自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 14:02
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 数组为空时，抛出{@link IllegalArgumentException}异常
     *
     * @param array   对象数组
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 14:03
     */
    public static void notEmpty(Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 当数组元素只有null时，抛出{@link IllegalArgumentException}异常
     *
     * @param array   对象数组
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 14:05
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            int arrLen = array.length;
            for (int i = 0; i < arrLen; ++i) {
                Object element = array[i];
                if (element == null) {
                    throw new IllegalArgumentException(message);
                }
            }
        }

    }

    /**
     * 当集合为空时，抛出{@link IllegalArgumentException}异常
     *
     * @param collection 集合
     * @param message    自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 14:06
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 当字典为空时，抛出{@link IllegalArgumentException}异常
     * @param map 字典
     * @param message 自定义异常消息
     * @author TanLianWang
     * @date 2019/2/18 14:06
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }
}
