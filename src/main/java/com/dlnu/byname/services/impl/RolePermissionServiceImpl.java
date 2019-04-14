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


package com.dlnu.byname.services.impl;

import com.dlnu.byname.domain.entity.RolePermissionDO;
import com.dlnu.byname.mapper.RolePermissionMapper;
import com.dlnu.byname.services.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 17:30
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    RolePermissionMapper rolePermissionMapper;
    @Override
    public List<RolePermissionDO> listByRoleId(Long roleId) {
        List<RolePermissionDO> listRolePermissionDO = rolePermissionMapper.get(roleId);
        if(listRolePermissionDO.isEmpty()){
            return null;
        }else{
            return listRolePermissionDO;
        }
    }
}
