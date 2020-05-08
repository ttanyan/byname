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


import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.core.Converter;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Bean操作类，主要用于复制属性
 *
 * @author TanLianWang
 * @version 1.0
 * @date 2018/11/23 17:21
 */
@SuppressWarnings({"unchecked", "WeakerAccess"})
public class BeanUtils {


    /**
     * 存放一些基本类型，和不需要复制的类型。需要人工维护
     */
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = new HashMap<>(14);

    static {
        PRIMITIVE_MAP.put(String.class, String.class);
        PRIMITIVE_MAP.put(Boolean.class, boolean.class);
        PRIMITIVE_MAP.put(Byte.class, byte.class);
        PRIMITIVE_MAP.put(Character.class, char.class);
        PRIMITIVE_MAP.put(Double.class, double.class);

        PRIMITIVE_MAP.put(Float.class, float.class);
        PRIMITIVE_MAP.put(Integer.class, int.class);
        PRIMITIVE_MAP.put(Long.class, long.class);
        PRIMITIVE_MAP.put(Short.class, short.class);
        PRIMITIVE_MAP.put(Date.class, Date.class);

        PRIMITIVE_MAP.put(BigDecimal.class, BigDecimal.class);
        PRIMITIVE_MAP.put(LocalDateTime.class, LocalDateTime.class);
        PRIMITIVE_MAP.put(LocalDate.class, LocalDate.class);
        PRIMITIVE_MAP.put(LocalTime.class, LocalTime.class);
    }

    /**
     * 复制属性，从一个对象复制到另一个对象。本方法不支持List to List。相同属性会被覆盖。
     *
     * @param source 源
     * @param target 目标
     * @author TanLianWang
     * @date 2018/12/20 14:51
     */
    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        Class<?> sourceClass = source.getClass();
        // 不复制类型（包含基本类型）无法在方法内赋值
        if (isCopyPrimitive(sourceClass) || isCopyPrimitive(target.getClass())) {
            return;
        }

        if (source instanceof Collection || target instanceof Collection) {
            throw new IllegalArgumentException("use copyList()");
        }

        if (source instanceof Map) {
            if (target instanceof Map) {
                ((Map) target).putAll((Map) source);
                return;
            }
            map2Bean((Map) source, target);
            return;
        }

        if (target instanceof Map) {
            bean2Map(source, (Map) target);
            return;
        }
        // bean to bean
        cgCopy(source, target);
    }

    /**
     * Map转Bean
     *
     * @param source 源Map
     * @param target 目标类型对象，非空
     * @author TanLianWang
     * @date 2018/12/20 15:06
     */
    public static void map2Bean(Map source, Object target) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        BeanMap.create(target).putAll(source);
    }

    /**
     * Map转Bean
     *
     * @param source 源Map
     * @param tClass 目标对象类型
     * @return java.util.Optional&lt;T&gt;
     * @author TanLianWang
     * @date 2019/1/18 11:52
     */
    public static <T> Optional<T> map2Bean(Map<?, ?> source, Class<T> tClass) {
        Assert.notNull(source, "Source must not be null");
        Optional<T> optional = ClassUtils.newInstance(tClass);
        optional.ifPresent(t -> BeanMap.create(t).putAll(source));
        return optional;
    }

    /**
     * Bean转Map
     *
     * @param source 源对象
     * @param target 目标Map
     * @author TanLianWang
     * @date 2018/12/20 15:07
     */
    public static void bean2Map(Object source, Map<Object, Object> target) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        BeanMap beanMap = BeanMap.create(source);
        Set<Map.Entry<Object, Object>> entrySet = beanMap.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            target.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Bean转Map
     *
     * @param source 源对象
     * @return java.util.Map&lt;java.lang.String,java.lang.Object&gt;
     * @author TanLianWang
     * @date 2019/1/18 11:52
     */
    public static Map<String, Object> bean2Map(Object source) {
        Assert.notNull(source, "Source must not be null");
        BeanMap beanMap = BeanMap.create(source);
        Map<String, Object> target = new HashMap<>(beanMap.size());
        Set<Map.Entry<String, Object>> entrySet = beanMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            target.put(entry.getKey(), entry.getValue());
        }
        return target;
    }

    /**
     * 复制属性，创建新对象并返回
     *
     * @param source      源
     * @param targetClass 目标类型
     * @return T
     * @author TanLianWang
     * @date 2018/12/20 14:50
     */
    public static <T> T copy(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        Assert.notNull(targetClass, "Target Class must not be null");
        Class<?> sourceClass = source.getClass();
        if (isCopyPrimitive(sourceClass)) {
            return (T) source;
        }

        if (sourceClass.isArray()) {
            throw new IllegalArgumentException("use copyArray()");
        }

        if (source instanceof Collection) {
            throw new IllegalArgumentException("use copyList()");
        }

        Optional<T> optional = ClassUtils.newInstance(targetClass);
        if (optional.isPresent()) {
            T t = optional.get();
            copyProperties(source, optional.get());
            return t;
        }
        return null;
    }

    /**
     * 复制数组
     *
     * @param source      源
     * @param targetClass 目标类型
     * @return T[]
     * @author TanLianWang
     * @date 2018/12/20 15:02
     */
    public static <T> T[] copyArray(Object[] source, Class<T> targetClass) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(targetClass, "Target Class must not be null");

        int sourceLength = source.length;
        Object target = Array.newInstance(targetClass, sourceLength);
        for (int i = 0; i < sourceLength; i++) {
            Array.set(target, i, BeanUtils.copy(source[i], targetClass));
        }
        return (T[]) target;
    }

    /**
     * 复制集合
     *
     * @param source      源
     * @param targetClass 目标类型
     * @return java.util.List<T>
     * @author TanLianWang
     * @date 2018/12/20 14:50
     */
    public static <T> Collection<T> copyCollection(Collection<?> source, Class<T> targetClass) {
        if (source == null) {
            return new ArrayList<>(0);
        }
        List<T> results = new ArrayList<>();
        for (Object obj : source) {
            results.add(copy(obj, targetClass));
        }
        return results;
    }

    /**
     * 复制集合
     *
     * @param source      源
     * @param targetClass 目标类型
     * @return java.util.List<T>
     * @author TanLianWang
     * @date 2018/12/20 14:50
     */
    public static <T> List<T> copyList(List<?> source, Class<T> targetClass) {
        return (List<T>) copyCollection(source, targetClass);
    }

    /**
     * 使用SpringFramework中CGLIB的BeanCopier实现。
     *
     * @param source 源
     * @param target 目标
     * @author TanLianWang
     * @date 2018/12/20 14:51
     */
    private static void cgCopy(Object source, Object target) {
        CachedBeanCopier.copy(source, target);
    }

    /**
     * 判断基本类型，基本类型不仅仅包括以下的几个基本类型。还包括了primitiveMap中设定的类型。
     *
     * @param clazz 需要判断的类型
     * @return boolean
     * * @see java.lang.String
     * * @see java.lang.Boolean#TYPE
     * * @see java.lang.Character#TYPE
     * * @see java.lang.Byte#TYPE
     * * @see java.lang.Short#TYPE
     * * @see java.lang.Integer#TYPE
     * * @see java.lang.Long#TYPE
     * * @see java.lang.Float#TYPE
     * * @see java.lang.Double#TYPE
     * * @see java.lang.Boolean#TYPE
     * * @see char
     * * @see byte
     * * @see short
     * * @see int
     * * @see long
     * * @see float
     * * @see double
     * @author TanLianWang
     * @date 2018/10/24 15:17
     */
    private static boolean isCopyPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || PRIMITIVE_MAP.containsKey(clazz);
    }

    /**
     * {@link BeanCopier}包装缓存类，提供copy方法，并使用{@link DeepCopyConverter}进行深度克隆
     *
     * @author TanLianWang
     * @version 1.0
     * @date 2018/12/20 14:52
     */
    static class CachedBeanCopier {

        static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<>();

        public static void copy(Object srcObj, Object destObj) {
            Class<?> srcClass = srcObj.getClass();
            Class<?> destClass = destObj.getClass();
            // 生成缓存key
            String key = genKey(srcClass, destClass);
            BeanCopier copier;
            if (!BEAN_COPIERS.containsKey(key)) {
                copier = BeanCopier.create(srcClass, destClass, true);
                BEAN_COPIERS.put(key, copier);
            } else {
                copier = BEAN_COPIERS.get(key);
            }
            copier.copy(srcObj, destObj, new DeepCopyConverter(destClass));
        }

        /**
         * 缓存Key生成方法{srcClazz}@{destClazz}
         *
         * @param srcClazz  源类型
         * @param destClazz 目标类型
         * @return java.lang.String
         * @author TanLianWang
         * @date 2018/12/20 14:52
         */
        private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
            return srcClazz.getName() + "@" + destClazz.getName();
        }

        /**
         * 用于深度复制的转换器
         *
         * @author TanLianWang
         * @version 1.0
         * @date 2018/12/11 15:58
         */
        static class DeepCopyConverter implements Converter {

            /**
             * 目标类型
             */
            private Class<?> target;

            /**
             * 构造器
             *
             * @param target 目标类型
             */
            public DeepCopyConverter(Class<?> target) {
                this.target = target;
            }

            @Override
            public Object convert(Object value, Class targetClass, Object methodName) {
                // value 源对象属性，targetClass目标对象属性类，methodName目标对象setter方法名
                if (value == null) {
                    return null;
                }

                if (value instanceof Collection) {
                    Collection values = (Collection) value;
                    Optional<Collection> optional = ClassUtils.newInstance(targetClass);
                    if (optional.isPresent()) {
                        Collection result = optional.get();
                        if (values.size() < 1) {
                            return result;
                        }
                        // 获取方法属性的泛型类型
                        Class genericTypeClass = getGenericType((String) methodName);
                        if (genericTypeClass == null) {
                            // 如果泛型类型为空，当作object
                            for (final Object source : values) {
                                result.add(BeanUtils.copy(source, source.getClass()));
                            }
                            return result;
                        }
                        // 执行属性copy
                        for (final Object source : values) {
                            result.add(BeanUtils.copy(source, genericTypeClass));
                        }
                        return result;
                    }

                } else if (value instanceof Map) {
                    // TODO 暂不针对Map进行深度克隆， 有需要时扩展
                } else if (targetClass.isArray()) {
                    if (!value.getClass().isArray()) {
                        return null;
                    }
                    Object[] source = (Object[]) value;
                    return copyArray(source, targetClass.getComponentType());
                } else if (!isCopyPrimitive(targetClass)) {
                    return BeanUtils.copy(value, targetClass);
                }
                return value;
            }

            Class getGenericType(String methodName) {
                String fieldName = StringUtils.upperCamelToLowerCamel(methodName.replaceFirst("set",
                        StringUtils.EMPTY));
                return ClassUtils.getGenericType(target, fieldName);
            }

        }
    }
}
