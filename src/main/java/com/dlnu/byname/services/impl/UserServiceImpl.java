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
 * 2019/4/13    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.services.impl;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.mapper.UserMapper;
import com.dlnu.byname.services.UserService;
import com.dlnu.byname.util.ClassUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/13 16:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    int sign = CommonConstant.RESULT_STATUS_FAIL;

    @Override
    public int addUser(UserDO userDO) {
        int sign = userMapper.insert(userDO);
        return sign;
    }

    @Override
    public int deleteUser(List<UserDO> list) {
       if(!list.isEmpty()){
           return userMapper.delete(list);
       }
       return CommonConstant.RESULT_STATUS_FAIL;
    }

    @Override
    public int updateUser(UserDO userDO) {
        if(ClassUtils.ObjIsNotNull(userDO)) {
            return userMapper.update(userDO);
        }else{
            return CommonConstant.RESULT_STATUS_FAIL;
        }


    }

    @Override
    public UserDO getUser(String number) {
        if(number.trim().length() == CommonConstant.STRING_LENGTH){
        UserDO userDO = userMapper.get(number);
        return userDO;
        }else {
            return null;
        }
    }

    @Override
    public List<UserDO> listUser() {
        List<UserDO> list = userMapper.listUser();
        return list;
    }

    @Override
    public List<UserDO> selectKeyUser(String keyWord) {
        return userMapper.selectKeyUser(keyWord);
    }

    @Override
    public Integer getCount() {
        return userMapper.getCount();
    }

}
