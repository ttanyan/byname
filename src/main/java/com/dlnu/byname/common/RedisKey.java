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

package com.dlnu.byname.common;

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

        private UserToken(){
            throw new UnsupportedOperationException();
        }
    }



}
