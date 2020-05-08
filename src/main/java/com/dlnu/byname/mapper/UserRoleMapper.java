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
     * @param userRoleDO
     * @return
     */
    int insert(UserRoleDO userRoleDO);

    /**
     * 批量添加角色权限
     *
     * @param list {@link UserRoleDO}
     * @return 影响数量
     */
    int batchInsert(List<UserRoleDO> list);

    /**
     * 批量删除角色权限
     *
     * @param list {@link UserRoleDO}
     * @return 影响数量
     */
    int batchDelete(List<UserRoleDO> list);

    /**
     * 删除用户角色
     * @param userRoleDO {@link UserRoleDO}
     * @return
     */
    int delete(UserRoleDO userRoleDO);

    /**
     * 修改用户角色
     *
     * @param userRoleDO {@link UserRoleDO}
     * @return int  返回结果
     * @author Tanlianwang
     * @date 2019/4/14 12:57
     */
    int update(UserRoleDO userRoleDO);

    /**
     *根据用户id获取userRole
     * @param id 用户id
     * @return list
     */
    List<UserRoleDO> get(Long id);

    /**
     * 查询所有用户角色
     * @return list
     */
    List<UserRoleDO> list();

}
