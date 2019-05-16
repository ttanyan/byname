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

import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.domain.entity.PermissionDO;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 17:57
 */
public interface PermissionMapper  {

    /**
     * 增加权限
     * @param permissionDO  {@link PermissionDO}
     * @return
     */
    int insert(PermissionDO permissionDO);

    /**
     * 删除权限
     * @param ids 权限id
     * @return
     */
    int delete(List<PermissionDO> list);

    /**
     * 修改权限
     * @param permissionDO
     * @return
     */
    int update(PermissionDO permissionDO);

    /**
     * 获取单个权限
     * @param id 权限id
     * @return PermissionDO
     */
    PermissionDO get(Long id);

    /**
     * 获取权限列表
     * @return
     */
    List<PermissionDO> listPermission();

    /** 
     * 根据roleId获取权限名称
     * @param roleId  角色id
     * @return java.util.Set&lt;java.lang.String&gt; 
     * @author  Tanlianwang
     * @date 2019/4/14 19:25
     */ 
    Set<UserPermissionBO> listByRoleId(Long roleId);

    /**
     * 获取所有的url
     * @return
     */
    List<String> listUrl();

    /**
     * 获取总数
     * @return
     */
    Integer getCount();
}
