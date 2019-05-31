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


package com.dlnu.byname.mapper;

import com.dlnu.byname.domain.entity.RolePermissionDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 13:59
 */
public interface RolePermissionMapper {
    /**
     * 增加角色权限
     * @param rolePermissionDO  {@link RolePermissionDO}
     * @return 影响数量
     */
    int insert(RolePermissionDO rolePermissionDO);

    /**
     * 批量添加角色权限
     * @param list {@link RolePermissionDO}
     * @return 影响数量
     */
    int batchInsert(List<RolePermissionDO> list);

    /**
     * 批量删除角色权限
     * @param list {@link RolePermissionDO}
     * @return 影响数量
     */
    int delete(List<RolePermissionDO> list);

    /**
     * 更新角色权限
     * @param rolePermissionDO {@link RolePermissionDO}
     * @return 影响数量
     */
    int update(RolePermissionDO rolePermissionDO);

    /**
     * 获取指定角色的权限
     * @param roleId 角色id
     * @return 角色权限数组
     */
    List<RolePermissionDO> get(Long roleId);
    /**
     * 查询所有角色的所有权限
     * @return java.util.List&lt;com.dlnu.byname.domain.entity.RolePermissionDO&gt;
     * @author  Tanlianwang
     * @date 2019/4/14 12:58
     */
    List<RolePermissionDO> list();
}
