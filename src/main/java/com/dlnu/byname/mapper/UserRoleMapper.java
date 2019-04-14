/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2019.
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
 * 2019/4/12    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.mapper;

import com.dlnu.byname.domain.entity.UserRoleDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 20:55
 */
public interface UserRoleMapper {
        /** 
         * 增加用户角色 
         * @return int 返回结果
         * @author  Tanlianwang
         * @date 2019/4/14 12:56
         */ 
        int insert(UserRoleDO userRoleDO);
        
       /** 
        * 删除用户角色 
        * @return int 返回结果
        * @author  Tanlianwang
        * @date 2019/4/14 12:58
        */ 
        int delete(UserRoleDO userRoleDO);
        
        /** 
         * 修改用户角色
         * @param userRoleDO  {@link UserRoleDO}
         * @return int  返回结果
         * @author  Tanlianwang
         * @date 2019/4/14 12:57
         */ 
        int update(UserRoleDO userRoleDO);
        /** 
         * 根据用户ID查询该用户的所有角色
         * @return java.util.List&lt;com.dlnu.byname.domain.entity.UserRoleDO&gt; 
         * @author  Tanlianwang
         * @date 2019/4/14 13:26
         */ 
        List<UserRoleDO> get(Long id);
        /** 
         * 查询所有用户所有角色
         * @return java.util.List&lt;com.dlnu.byname.domain.entity.UserRoleDO&gt; 
         * @author  Tanlianwang
         * @date 2019/4/14 12:58
         */ 
        List<UserRoleDO> list();

}
