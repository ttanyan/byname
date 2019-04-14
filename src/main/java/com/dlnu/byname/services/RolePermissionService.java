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
}
