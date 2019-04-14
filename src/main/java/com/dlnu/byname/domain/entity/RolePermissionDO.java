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


package com.dlnu.byname.domain.entity;

import com.dlnu.byname.common.BaseDO;

import java.util.StringJoiner;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 15:17
 */
public class RolePermissionDO extends BaseDO {
    /**
     * 权限id
     */
    private Long permissionId;
    /**
     * 角色id
     */
    private Long roleId;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RolePermissionDO.class.getSimpleName() + "[", "]")
                .add("permissionId=" + permissionId)
                .add("roleId=" + roleId)
                .toString();
    }
}
