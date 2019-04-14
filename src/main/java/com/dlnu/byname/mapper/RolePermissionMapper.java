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
     * @return int 返回结果
     * @author  Tanlianwang
     * @date 2019/4/14 12:56
     */
    int insert(RolePermissionDO rolePermissionDO);

    /**
     * 删除角色权限
     * @return int 返回结果
     * @author  Tanlianwang
     * @date 2019/4/14 12:58
     */
    int delete(RolePermissionDO rolePermissionDO);

    /**
     * 修改角色权限
     * @param rolePermissionDO  {@link RolePermissionDO}
     * @return int  返回结果
     * @author  Tanlianwang
     * @date 2019/4/14 12:57
     */
    int update(RolePermissionDO rolePermissionDO);
    /**
     * 根据角色ID查询该角色的所有权限
     * @return java.util.List&lt;com.dlnu.byname.domain.entity.UserRoleDO&gt;
     * @author  Tanlianwang
     * @date 2019/4/14 13:26
     */
    List<RolePermissionDO> get(Long roleId);
    /**
     * 查询所有角色的所有权限
     * @return java.util.List&lt;com.dlnu.byname.domain.entity.UserRoleDO&gt;
     * @author  Tanlianwang
     * @date 2019/4/14 12:58
     */
    List<RolePermissionDO> list();
}
