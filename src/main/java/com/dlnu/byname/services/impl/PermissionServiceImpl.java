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
import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.domain.entity.PermissionDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import com.dlnu.byname.mapper.PermissionMapper;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.services.UserRoleService;
import com.dlnu.byname.util.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 15:22
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    PermissionMapper permissionMapper;
    @Resource
    UserRoleService userRoleService;
    /**
     * 结果状态
     */
    int sign = CommonConstant.RESULT_STATUS_FAIL;
    @Override
    public Set<UserPermissionBO> listByUserNumber(String number) {
        List<UserRoleDO> listUserRole = userRoleService.listUserRole(number);
        Set<UserPermissionBO> listPermissions = new HashSet<>();
        for (UserRoleDO userRoleDO:listUserRole){
           Set<UserPermissionBO> listPermission = permissionMapper.listByRoleId(userRoleDO.getRoleId());
           listPermissions.addAll(listPermission);
        }
        return  listPermissions;
    }

    @Override
    public Boolean needInterceptor(String url) {
        List<String> listUrl = permissionMapper.listUrl();
        for(String Purl:listUrl){
            if(Purl.equals(url)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int insertPermission(PermissionDO permissionDO) {
        if(permissionDO != null){
            sign = permissionMapper.insert(permissionDO);
        }
        return sign;

    }

    @Override
    public int deletePermission(List<PermissionDO> list) {
        if(!list.isEmpty()) {
            sign = permissionMapper.delete(list);
        }
        return sign;

    }

    @Override
    public int updatePermission(PermissionDO permissionDO) {
        if(ClassUtils.ObjIsNotNull(permissionDO)){
            sign = permissionMapper.update(permissionDO);
        }
        return sign;
    }

    @Override
    public List<PermissionDO> listPermission() {
        List<PermissionDO> permissionDOList = permissionMapper.listPermission();
        return permissionDOList;
    }

    @Override
    public List<PermissionDO> selectKeyPermission(String keyWord) {
           List<PermissionDO> permissionDOKeyList = permissionMapper.selectKeyPermission(keyWord);
           return permissionDOKeyList;
    }

    @Override
    public Integer getCount() {
        return permissionMapper.getCount();
    }
}
