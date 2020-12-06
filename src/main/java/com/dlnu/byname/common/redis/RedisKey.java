/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-04-29 10:04                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.common.redis;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/4/29 10:04
 */
public class RedisKey {

    /**
     * 默认前缀
     */
    private static final String PERFIX_BYNAME = "byname:";

    private RedisKey(){

        throw new UnsupportedOperationException();
    }

    /**
     * 用户Token常量
     */
    public static class UserToken{

        /**
         * 用户token前缀
         */
        public static final String USER_NAME = PERFIX_BYNAME+"user:";

        /**
         * List缓存
         */
        public static final  String LIST_NAME = PERFIX_BYNAME+"list:";
        /**
         * String缓存
         */
        public static final  String STRING_NAME = PERFIX_BYNAME+"string:";
        /**
         * set缓存
         */
        public static final  String SET_NAME = PERFIX_BYNAME+"set:";
        /**
         * zset缓存
         */
        public static final  String ZSET_NAME = PERFIX_BYNAME+"zset:";
        /**
         * HASH缓存
         */
        public static final  String HASH_NAME = PERFIX_BYNAME+"hash:";

        private UserToken(){
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 统计常量
     */
    public static class Count{

        /**
         * 统计包名前缀，{@value}
         */
        private static final String PREFIX_COUNT = PERFIX_BYNAME + "count:";
        /**
         * 设备统计前缀，单独的Key存储所有设备相关统计，如总量统计、未关联统计和过期统计。，{@value}
         */
        private static final String PREFIX_COUNT_DEVICE = PREFIX_COUNT + "device:";
        /**
         * 设备总量统计Key名，{@value}
         */
        public static final String COUNT_DEVICE_TOTAL = PREFIX_COUNT_DEVICE + "total";
        /**
         * 设备未关联分组统计Key名，{@value}
         */
        public static final String COUNT_DEVICE_UNCORRELATION = PREFIX_COUNT_DEVICE + "uncorrelation";
        /**
         * 设备30天到期统计Key名，{@value}
         */
        public static final String COUNT_DEVICE_EXPIRES_THIRTY_DAYS = PREFIX_COUNT_DEVICE + "expires_thirty_days";

        /**
         * 分组设备统计Key名前缀。{@value}
         */
        public static final String PREFIX_COUNT_GROUP = PREFIX_COUNT + "group:";
        /**
         * 分组设备统计Key名前缀，不含下级，不存hash。{@value}
         */
        public static final String PREFIX_COUNT_DEVICE_GROUP = PREFIX_COUNT_GROUP + "itself_device:";

        /**
         * 分组设备统计Key名前缀，含下级，不存hash。{@value}
         */
        public static final String PREFIX_COUNT_DEVICE_GROUP_LOWER = PREFIX_COUNT_GROUP + "lower_device:";

        /**
         * 分组未激活设备统计Key名前缀，不含下级，不存hash。{@value}
         */
        public static final String PREFIX_COUNT_DEVICE_GROUP_UNACTIVATED = PREFIX_COUNT_GROUP +
                "itself_unactivated_device:";

        /**
         * 分组未激活设备统计Key名前缀，含下级，不存hash。{@value}
         */
        public static final String PREFIX_COUNT_DEVICE_GROUP_LOWER_UNACTIVATED = PREFIX_COUNT_GROUP +
                "lower_unactivated_device:";

        private Count(){
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 告警用户设置Redis常量
     */
    public static class AlarmPush {
        /**
         * 告警用户设置缓存前缀
         */
        private static final String PREFIX = PERFIX_BYNAME + "alarm:push:";
        /**
         * 告警用户设置缓存前缀Key
         */
        public static final String USER_SETTING = PREFIX + "user_setting";
        /**
         * 告警通信管道纬度未阅读数
         */
        public static final String CHANNEL_UNREAD = PREFIX + "channel_unread";
        /**
         * websocket分组通信管道缓存
         */
        public static final String CHANNEL_CACHE = PREFIX + "channel_cache";

        private AlarmPush() {
            throw new UnsupportedOperationException();
        }
    }



}
