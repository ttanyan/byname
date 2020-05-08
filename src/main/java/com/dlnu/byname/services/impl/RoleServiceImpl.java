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
import com.dlnu.byname.domain.entity.RoleDO;
import com.dlnu.byname.mapper.RoleMapper;
import com.dlnu.byname.services.RoleService;
import com.dlnu.byname.util.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 19:02
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public int insertRole(RoleDO roleDO) {
        if(ClassUtils.ObjIsNotNull(roleDO)){
            return roleMapper.insert(roleDO);
        }else{
            return CommonConstant.RESULT_STATUS_FAIL;
        }
    }

    @Override
    public int deleteRole(List<RoleDO> list) {
        if(!list.isEmpty()){
            return roleMapper.delete(list);
        }
        return CommonConstant.RESULT_STATUS_FAIL;
    }

    @Override
    public int updateRole(RoleDO roleDO) {
       if(ClassUtils.ObjIsNotNull(roleDO)){
           return roleMapper.update(roleDO);
       }else{
           return  CommonConstant.RESULT_STATUS_FAIL;
       }
    }

    @Override
    public Set<String> listRoleName(String number) {
        Set<String> listRoleName = roleMapper.listByUserNumber(number);
        if(listRoleName.isEmpty()){
            return null;
        }else{
        return listRoleName;

        }
    }

    @Override
    public List<RoleDO> listRole() {
        List<RoleDO> roleDOList = roleMapper.listRole();
        return roleDOList;
    }

    @Override
    public List<RoleDO> selectKeyRole(String keyWord) {
         return roleMapper.selectKeyRole(keyWord);
    }

    @Override
    public Integer getCount() {
        return roleMapper.getCount();
    }
}
