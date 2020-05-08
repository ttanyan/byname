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

import com.google.common.base.CaseFormat;

import java.text.Collator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作类
 *
 * @author TanLianWang
 * @version 1.0
 * @date 2018/11/23 17:21
 */
public class StringUtils {
    /**
     * 空字符串，{@value}
     */
    public static final String EMPTY = "";
    /**
     * 点、dot，{@value}
     */
    public static final char CHAR_PERIOD = '.';
    /**
     * 点、dot，{@value}
     */
    public static final String PERIOD = CHAR_PERIOD + EMPTY;
    /**
     * 问号，{@value}
     */
    public static final char CHAR_QUESTION_MARK = '?';
    /**
     * 问号，{@value}
     */
    public static final String QUESTION_MARK = CHAR_QUESTION_MARK + EMPTY;
    /**
     * 感叹号，{@value}
     */
    public static final char CHAR_EXCLAMATION_MARK = '!';
    /**
     * 感叹号，{@value}
     */
    public static final String EXCLAMATION_MARK = CHAR_EXCLAMATION_MARK + EMPTY;
    /**
     * 逗号，{@value}
     */
    public static final char CHAR_COMMA = ',';
    /**
     * 逗号，{@value}
     */
    public static final String COMMA = CHAR_COMMA + EMPTY;
    /**
     * 冒号，{@value}
     */
    public static final char CHAR_COLON = ':';
    /**
     * 冒号，{@value}
     */
    public static final String COLON = CHAR_COLON + EMPTY;
    /**
     * 分号，{@value}
     */
    public static final char CHAR_SEMICOLON = ';';
    /**
     * 分号，{@value}
     */
    public static final String SEMICOLON = CHAR_SEMICOLON + EMPTY;
    /**
     * 短横线，{@value}
     */
    public static final char CHAR_HYPHEN = '-';
    /**
     * 短横线，{@value}
     */
    public static final String HYPHEN = CHAR_HYPHEN + EMPTY;
    /**
     * 斜杠，{@value}
     */
    public static final char CHAR_BACKSLASH = '/';
    /**
     * 斜杠，{@value}
     */
    public static final String BACKSLASH = CHAR_BACKSLASH + EMPTY;
    /**
     * 百分号，{@value}
     */
    public static final char CHAR_PERCENT = '%';
    /**
     * 百分号，{@value}
     */
    public static final String PERCENT = CHAR_PERCENT + EMPTY;

    /**
     * 下划线，{@value}
     */
    public static final char CHAR_UNDERLINE = '_';
    /**
     * 下划线，{@value}
     */
    public static final String UNDERLINE = CHAR_UNDERLINE + EMPTY;

    /**
     * 中文比较器
     */
    private static final Collator COLLATOR = Collator.getInstance(java.util.Locale.CHINA);

    /**
     * 判断字符串是否为空字符串，包含空格的字符串会返回false
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:45
     */
    public static boolean isEmpty(String str) {
        return str == null || EMPTY.equals(str);
    }

    /**
     * 判断字符串是否非空字符串，包含空格的字符串会返回true
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:46
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断是否为空，含空字符串。
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/14 18:55
     */
    public static boolean isBlank(CharSequence str) {
        return str == null || !containsText(str);
    }

    /**
     * 判断是否不为空，含空字符串。
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/14 18:55
     */
    public static boolean isNotBlank(CharSequence str) {
        return str != null && containsText(str);
    }

    /**
     * 判断字符串是否有长度，length大于0
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:46
     */
    public static boolean hasLength(CharSequence str) {
        return str != null && str.length() > 0;
    }

    /**
     * 判断字符串是否有长度，length大于0
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:47
     */
    public static boolean hasLength(String str) {
        return str != null && !str.isEmpty();
    }

    /**
     * 判断字符串是否有任意一个字符
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:47
     */
    public static boolean hasText(CharSequence str) {
        return hasLength(str) && containsText(str);
    }

    /**
     * 判断字符串是否有任意一个字符，不包含:空格、tab键、换行符
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:47
     */
    public static boolean hasText(String str) {
        return hasLength(str) && containsText(str);
    }

    /**
     * 判断字符串是否包含任意一个字符
     *
     * @param str 字符串
     * @return boolean
     * @author TanLianWang
     * @date 2019/1/11 16:48
     */
    private static boolean containsText(CharSequence str) {
        int strLen = str.length();

        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 对象toString方法，当对象为null时，返回空字符串（而不是null）
     *
     * @param o 对象
     * @return java.lang.String
     * @author TanLianWang
     * @date 2018/12/29 10:30
     */
    public static String toString(Object o) {
        if (o == null) {
            return EMPTY;
        }
        return String.valueOf(o);
    }

    /**
     * 反转字符串。
     *
     * @param str 字符串
     * @return java.lang.String
     * @author TanLianWang
     * @date 2018/12/25 14:07
     */
    public static String reverse(String str) {
        Assert.hasLength(str, "str");
        boolean hasSurrogates = false;
        int count = str.length();
        int n = count - 1;
        char[] value = str.toCharArray();
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            for (int i = 0; i < count - 1; i++) {
                char c2 = value[i];
                if (Character.isLowSurrogate(c2)) {
                    char c1 = value[i + 1];
                    if (Character.isHighSurrogate(c1)) {
                        value[i++] = c1;
                        value[i] = c2;
                    }
                }
            }
        }
        return new String(value);
    }

    /**
     * 驼峰转下划线。
     *
     * @param str 字符串
     * @return java.lang.String
     * @author TanLianWang
     * @date 2018/12/25 14:08
     */
    public static String camelToUnderLine(String str) {
        Assert.notNull(str);
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    /**
     * 下划线转驼峰。
     *
     * @param str 字符串
     * @return java.lang.String
     * @author TanLianWang
     * @date 2018/12/25 14:08
     */
    public static String underLineToCamel(String str) {
        Assert.notNull(str);
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }

    /**
     * 大写字母开头的驼峰命名转小写字母开头的驼峰
     *
     * @param str 字符串
     * @return java.lang.String
     * @author TanLianWang
     * @date 2018/12/25 14:08
     */
    public static String upperCamelToLowerCamel(String str) {
        Assert.notNull(str);
        //str.substring(0, 1).toLowerCase() + str.substring(1)
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, str);

    }


    /**
     * 中文比较
     *
     * @param source 中文字符串
     * @param target 中文字符串
     * @return int
     * @author TanLianWang
     * @date 2019/1/11 16:48
     */
    public static int compareChinese(String source, String target) {
        return COLLATOR.compare(source, target);
    }

    /**
     * 获取去除前后空格的字符串
     * obj为null时，返回""
     *
     * @param obj 对象
     * @return java.lang.String
     * @author wanghe
     * @date 2019/1/16 17:01
     */
    public static String getString(Object obj) {
        return toString(obj).trim();
    }

    /**
     * 获取去除前后空格的字符串
     * obj为null时，返回null
     *
     * @param obj
     * @return java.lang.String
     * @author wanghe
     * @date 2019/1/16 17:05
     */
    public static String getStringWithNull(Object obj) {
        if (obj == null) {
            return null;
        }
        return toString(obj).trim();
    }

    /**
     * 验证字符串是否符合正则表达式
     *
     * @param regEx 正则表达式
     * @param str   验证字符串
     * @return boolean true 符合
     * @author wanghe
     * @date 2019/1/17 10:49
     */
    public static boolean checkString(String regEx, String str) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    /**
     * 拼接字符串
     * 
     * @param str 字符串
     * @return java.lang.String
     * @author zhengjunwei
     * @date 2019年1月21日 下午3:15:51
     */
    public static String join(String... str) {
        StringBuilder buf = new StringBuilder();
        for (String s : str) {
            buf.append(s);
        }
        return buf.toString();
    }
}
