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


package com.dlnu.byname.domain.bo;

import java.util.StringJoiner;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 20:18
 */
public class UserPermissionBO {
    /**
     * 用户权限id
     */
    private Long id;
    /**
     * 用户权限名称
     */
    private String permissionName;
    /**
     * 用户权限URL
     */
    private String permissionURL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionURL() {
        return permissionURL;
    }

    public void setPermissionURL(String permissionURL) {
        this.permissionURL = permissionURL;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserPermissionBO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("permissionName='" + permissionName + "'")
                .add("permissionURL='" + permissionURL + "'")
                .toString();
    }
}
