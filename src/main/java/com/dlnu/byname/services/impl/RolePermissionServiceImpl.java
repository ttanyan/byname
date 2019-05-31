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

import com.dlnu.byname.constant.CommonConstant;
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

    @Override
    public int batchInsertByRolePermission(List<RolePermissionDO> list) {
        if(!list.isEmpty()){
            int sign = rolePermissionMapper.batchInsert(list);
            return sign;
        }else{
            return CommonConstant.RESULT_STATUS_FAIL;
        }
    }

    @Override
    public int batchDeleteByRolePermission(List<RolePermissionDO> list) {
        if(!list.isEmpty()){
            int sign = rolePermissionMapper.delete(list);
            return sign;
        }else{
            return CommonConstant.RESULT_STATUS_FAIL;
        }
    }

    @Override
    public List<RolePermissionDO> getRolePermission(Long roleId) {
        if(!roleId.equals("")){
            return rolePermissionMapper.get(roleId);
        }else {
            return null;
        }
    }
}
