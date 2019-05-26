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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.NumberUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class反射工具类
 * @author zhangduanfeng
 * @version 1.0
 * @date 2018/11/23 17:22
 */
@SuppressWarnings("unchecked")
public class ClassUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtils.class);
    /**
     * 类名称前缀
     */
    private static final String TYPE_NAME_PREFIX = "class ";


    /**
     * 获取类中某个属性的泛型类型
     *
     * @param target    目标类Class, {@link Class}
     * @param fieldName 类中的属性名称
     * @return java.lang.Class&lt;?&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:36
     */
    public static Class<?> getGenericType(Class<?> target, String fieldName) {
        return getField(target, fieldName).map(ClassUtils::getGenericType).orElse(null);
    }

    /**
     * 获取某个属性的泛型类型
     *
     * @param field 属性{@link Field}
     * @return java.lang.Class&lt;?&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:36
     */
    public static Class<?> getGenericType(Field field) {
        Objects.requireNonNull(field);
        Type type;
        type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            String classStr = t.getActualTypeArguments()[0].toString().replace("class ", "");
            try {
                return Thread.currentThread().getContextClassLoader().loadClass(classStr);
            } catch (ClassNotFoundException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * 从type中获取类名
     *
     * @param type {@link Type}
     * @return java.lang.String
     * @author zhangduanfeng
     * @date 2019/1/18 11:35
     */
    public static String getClassName(Type type) {
        if (type == null) {
            return StringUtils.EMPTY;
        }
        String className = type.toString();
        if (className.startsWith(TYPE_NAME_PREFIX)) {
            className = className.substring(TYPE_NAME_PREFIX.length());
        }
        return className;
    }

    /**
     * 获取类Type的class
     *
     * @param type {@link Type}
     * @return java.lang.Class&lt;?&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:34
     */
    public static Class<?> getClass(Type type) {
        String className = getClassName(type);
        if (className == null || className.isEmpty()) {
            return null;
        }
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }


    /**
     * 根据目标Class创建新对象，只处理部分集合相关的接口，但如果是其它接口，返回空。
     *
     * @param targetClass {@link Class}
     * @return java.util.Optional&lt;T&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:34
     */
    public static <T> Optional<T> newInstance(Class<T> targetClass) {
        if (targetClass == null) {
            throw new NullPointerException("targetClass");
        }

        if (targetClass.isArray()) {
            return Optional.of((T) Array.newInstance(targetClass.getComponentType(), 0));
        }
        if (targetClass.isInterface()) {
            if (List.class.isAssignableFrom(targetClass)) {
                return Optional.of((T) new ArrayList<>(0));
            } else if (Set.class.isAssignableFrom(targetClass)) {
                return Optional.of((T) new LinkedHashSet<>(0));
            } else if (Map.class.isAssignableFrom(targetClass)) {
                return Optional.of((T) new LinkedHashMap<>(0));
            }
        }

        try {
            return Optional.of(targetClass.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }


    /**
     * 获取一个类所有get方法
     *
     * @param cls {@link Class}
     * @return java.util.List&lt;java.lang.reflect.Method&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:36
     */
    public static List<Method> getReadMethods(Class<?> cls) {
        PropertyDescriptor[] descriptors = getBeanProperties(cls);
        List<Method> methods = Lists.newArrayListWithCapacity(descriptors.length);
        Method method;
        for (PropertyDescriptor descriptor : descriptors) {
            method = descriptor.getReadMethod();
            if (method != null) {
                methods.add(method);
            }
        }
        return methods;
    }


    /**
     * 获取一个类所有set方法
     *
     * @param cls {@link Class}
     * @return java.util.List&lt;java.lang.reflect.Method&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:37
     */
    public static List<Method> getWriteMethods(Class<?> cls) {
        PropertyDescriptor[] descriptors = getBeanProperties(cls);
        List<Method> methods = Lists.newArrayListWithCapacity(descriptors.length);
        Method method;
        for (PropertyDescriptor descriptor : descriptors) {
            method = descriptor.getWriteMethod();
            if (method != null) {
                methods.add(method);
            }
        }
        return methods;
    }


    /**
     * 获取一个类的所有字段
     *
     * @param cls {@link Class}
     * @return java.util.List&lt;java.lang.reflect.Field&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:51
     */
    public static List<Field> listFiled(Class<?> cls) {
        Map<String, Field> map = Arrays.stream(cls.getDeclaredFields())
                .collect(Collectors.toMap(Field::getName, field -> field));

        Class<?> handleClass = cls.getSuperclass();

        while (handleClass != Object.class) {
            if (!Modifier.isInterface(handleClass.getModifiers())) {
                Arrays.stream(handleClass.getDeclaredFields()).forEach(field -> map.putIfAbsent(field.getName(), field));
            }
            handleClass = handleClass.getSuperclass();
        }

        return Lists.newArrayList(map.values());
    }


    /**
     * 获取一个类中的指定属性
     *
     * @param cls       {@link Class}
     * @param fieldName 属性名称
     * @return java.util.Optional&lt;java.lang.reflect.Field&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:40
     */
    public static Optional<Field> getField(Class<?> cls, String fieldName) {
        return listFiled(cls).stream().filter(field -> field.getName().equals(fieldName)).findFirst();
    }

    /**
     * 获取一个类中的指定方法
     *
     * @param cls        {@link Class}
     * @param methodName 方法名称
     * @return java.util.Optional&lt;java.lang.reflect.Method&gt;
     * @author zhangduanfeng
     * @date 2019/1/18 11:40
     */
    public static Optional<Method> getMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) {
        try {
            return Optional.ofNullable(cls.getDeclaredMethod(methodName, parameterTypes));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }


    /**
     * 使用java.beans中提供的工具获取一个类所有属性{@link PropertyDescriptor}
     *
     * @param cls {@link Class}
     * @return java.beans.PropertyDescriptor[]
     * @author zhangduanfeng
     * @date 2019/1/18 11:38
     */
    public static PropertyDescriptor[] getBeanProperties(Class<?> cls) {
        try {
            return Introspector.getBeanInfo(cls).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return new PropertyDescriptor[0];
    }


    /**
     * 向指定对象写入指定属性值。如果指定属性不存在或写入值失败会抛出异常{@link IllegalAccessException}
     *
     * @param obj   任意对象，{@link Object}
     * @param field 任意属性
     * @param value 任意value
     * @author zhangduanfeng
     * @date 2019/1/18 11:44
     */
    public static void setValue(Object obj, Field field, Object value) throws IllegalAccessException {
        if (obj != null && field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }

    /**
     * 反射获取指定对象中指定属性的值。如果指定属性不存在或取值失败会抛出异常{@link IllegalAccessException}
     *
     * @param obj   任意对象，{@link Object}
     * @param field 任意属性
     * @return java.lang.Object
     * @author zhangduanfeng
     * @date 2019/1/18 11:47
     */
    public static Object getValue(Object obj, Field field) throws IllegalAccessException {
        if (field != null) {
            field.setAccessible(true);
            return field.get(obj);
        }
        return null;
    }


    /**
     * 反射获取指定对象中指定属性的值，并转换为int。如果指定属性不存在或取值失败会抛出异常{@link IllegalAccessException}
     *
     * @param obj   任意对象，{@link Object}
     * @param field 任意属性
     * @return int intValue
     * @author zhangduanfeng
     * @date 2019/1/18 11:43
     */
    public static int getIntValue(Object obj, Field field) throws IllegalAccessException {
        return 0;
    }

    /**
     * 反射获取指定对象中指定属性的值，并转换为int。如果指定属性不存在或取值失败会抛出异常{@link IllegalAccessException}
     *
     * @param obj       任意对象，{@link Object}
     * @param filedName 任意属性名称
     * @return int intValue
     * @author zhangduanfeng
     * @date 2019/1/18 11:42
     */
    public static int getIntValue(Object obj, String filedName) throws IllegalAccessException {
        if (obj != null) {
            Optional<Field> optional = getField(obj.getClass(), filedName);
            if (optional.isPresent()) {
                return getIntValue(obj, filedName);
            }
        }
        return 0;
    }

    /**
     * 判断一个对象是否为空
     * @param object 传入的对象
     * @return 空-false 不为空-true
     */
    public static boolean ObjIsNotNull(Object object) {
        if (null == object) {
            return false;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
