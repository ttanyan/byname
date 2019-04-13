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


package com.dlnu.byname.controller;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.mapper.UserMapper;
import com.dlnu.byname.services.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/13 14:26
 */
@RestController
@RequestMapping("")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(UserDO userDO){
        // 密钥
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodedPassword = new SimpleHash(CommonConstant.ENCRYPTION_METHOD, userDO.getPassword(), salt, CommonConstant.ENCRYPTION_TIME).toString();
        userDO.setSalt(salt);
        userDO.setPassword(encodedPassword);
        userService.addUser(userDO);
        return "index";

    }




}
