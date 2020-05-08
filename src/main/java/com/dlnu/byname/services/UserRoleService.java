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

import com.dlnu.byname.domain.entity.UserRoleDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 15:49
 */
public interface UserRoleService {

    /**
     * 批量添加用户角色
     * @param list 用户角色列表
     * @return 添加个数
     */
    Integer batchInsert(List<UserRoleDO> list);

    /**
     * 批量删除用户角色
     * @param list 用户角色列表
     * @return 删除个数
     */
    Integer batchDelete(List<UserRoleDO> list);

    /**
     * 根据用户number查询roleId
     * @param number 用户编码
     * @return java.util.Set&lt;com.dlnu.byname.domain.entity.UserRoleDO&gt;
     * @author Tanlianwang
     * @date 2019/4/14 16:12
     */
    List<UserRoleDO> listUserRole(String number);

    /**
     * 根据用户Id查询关联角色
     * @param id  用户id
     * @return 用户-角色
     */
    List<UserRoleDO> getUserRole(Long id);

}
