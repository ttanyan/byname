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
 * 2019/4/14    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.services;

import com.dlnu.byname.domain.entity.RolePermissionDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 17:26
 */
public interface RolePermissionService {
    /** 
     * 根据RoleId查询角色的权限
     * @param roleId  角色id
     * @return java.util.List&lt;com.dlnu.byname.domain.entity.RolePermissionDO&gt; 
     * @author  Tanlianwang
     * @date 2019/4/14 17:29
     */ 
    List<RolePermissionDO> listByRoleId(Long roleId);

    /**
     * 批量插入角色权限ID
     * @param list 角色权限集合
     * @return 插入数量
     */
    int batchInsertByRolePermission(List<RolePermissionDO> list);

    /**
     * 批量删除角色权限ID
     * @param list 角色权限集合
     * @return 删除数量
     */
    int batchDeleteByRolePermission(List<RolePermissionDO> list);
    /**
     * 根据roleID获取角色权限ID
     * @param roleId 角色ID
     * @return {@link RolePermissionDO}
     */
    List<RolePermissionDO> getRolePermission(Long roleId);
}
