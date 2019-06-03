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

import com.dlnu.byname.domain.entity.RoleDO;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 18:59
 */
public interface RoleService {
    /**
     * 增加角色
     * @param roleDO 角色
     * @return 1-成功，0-失败
     */
    int insertRole(RoleDO roleDO);

    /**
     * 批量删除
     * @param list 角色
     * @return 删除数量
     */
    int deleteRole(List<RoleDO> list);

    /**
     * 修改角色
     * @param roleDO 角色
     * @return 1-成功 0-失败
     */
    int updateRole(RoleDO roleDO);

    /**
     * 根据用户编号获取RoleName
     * @param number 用户编号
     * @return java.util.List&lt;java.lang.String&gt;
     * @author Tanlianwang
     * @date 2019/4/14 19:01
     */
    Set<String> listRoleName(String number);

    /**
     * 获取角色信息
     * @return 角色信息
     */
    List<RoleDO> listRole();

    /**
     * 关键字搜索
     * @param keyWord 关键字
     * @return 搜索结果
     */
    List<RoleDO> selectKeyRole(String keyWord);

    /**
     * 获取总数
     * @return 总数
     */
    Integer getCount();
}
