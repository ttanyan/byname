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

import com.dlnu.byname.domain.entity.RoleDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 15:35
 */
public interface RoleMapper {

    /**
     * 增加角色
     * @param roleDO {@link RoleDO}
     * @return java.Integer
     */
    int insert(RoleDO roleDO);
    /**
     * 删除角色
     * @param id  角色id
     * @return
     */
    int delete(Long id);
    /**
     * 修改角色
     * @param roleDO {@link RoleDO}
     * @return java.Integer
     */
    int update(RoleDO roleDO);
    /**
     * 获取单个角色
     * @param id 角色id
     * @return java.Integer
     */
    RoleDO get(Long id);

    /**
     * 获取所有的角色
     * @return List<RoleDO>
     */
    List<RoleDO> listRole();
}
