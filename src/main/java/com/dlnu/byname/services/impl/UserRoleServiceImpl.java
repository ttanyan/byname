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
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import com.dlnu.byname.mapper.UserMapper;
import com.dlnu.byname.mapper.UserRoleMapper;
import com.dlnu.byname.services.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 15:54
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    UserMapper userMapper;


    @Override
    public Integer batchInsert(List<UserRoleDO> list) {
       if(list.isEmpty()){
           return null;
       }
       return userRoleMapper.batchInsert(list);
    }

    @Override
    public Integer batchDelete(List<UserRoleDO> list) {
        if(list.isEmpty()){
            return null;
        }
        return userRoleMapper.batchDelete(list);
    }

    @Override
    public List<UserRoleDO> listUserRole(String number) {
        if(number.trim().length() == CommonConstant.STRING_LENGTH) {
            UserDO userDO = userMapper.get(number);
            System.out.println(userDO.getId());
            List<UserRoleDO> listUserRole = userRoleMapper.get(userDO.getId());
            return listUserRole;
        }else {
            return null;
        }
    }

    @Override
    public List<UserRoleDO> getUserRole(Long id) {
        if(!id.equals(CommonConstant.EMPTY_STRING)){
            return userRoleMapper.get(id);
        }else{
            //TODO 需要优化 返回空则会出现空指针异常
            return  null;
        }
    }
}
