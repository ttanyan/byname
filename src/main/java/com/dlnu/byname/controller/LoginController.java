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

import com.dlnu.byname.annotation.MyAnnotation;
import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/13 14:26
 * 用户登录以及注册
 */
@Controller
@RequestMapping("")
public class LoginController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @MyAnnotation
    public String register(UserDO userDO){
        // 密钥
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodedPassword = new SimpleHash(CommonConstant.ENCRYPTION_METHOD, userDO.getPassword(), salt, CommonConstant.ENCRYPTION_TIME).toString();
        userDO.setSalt(salt);
        userDO.setPassword(encodedPassword);
        int status = userService.addUser(userDO);
         if(status == CommonConstant.RESULT_STATUS_SUCCESS){
             return "login";
         }
        return "register";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String number, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(number,password);
        try{
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject",subject);
            UserDO userDO = userService.getUser(number);
            model.addAttribute("loginUser",userDO);
            return "index";

        }catch (AuthenticationException e){
            model.addAttribute("loginMessage", "用户名或密码错误，请重新登录");
            return "login";
        }
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("loginMessage","已安全退出");
        return "login";
    }




}
