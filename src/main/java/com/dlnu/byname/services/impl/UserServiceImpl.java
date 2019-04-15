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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/13 16:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;


    @Override
    public int addUser(UserDO userDO) {
        int status = userMapper.insert(userDO);
        return status;
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
}
