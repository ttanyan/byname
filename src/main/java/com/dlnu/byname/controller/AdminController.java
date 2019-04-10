/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
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
 * 2018年12月14日    TanLianWang         Create the class
 * http://www.jimilab.com/
 */

package com.dlnu.byname.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dlnu.byname.annotation.MyAnnotation;
import com.dlnu.byname.domain.entity.ClientDO;
import com.dlnu.byname.domain.entity.User;
import com.dlnu.byname.mapper.UserMapper;
import com.dlnu.byname.services.ClientService;
import com.dlnu.byname.util.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author TanLianWang
 * @version 1.0
 * @FileName JimiTestController.java
 * @Description:
 * @Date 2018年12月14日 下午6:17:45
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    UserMapper usermapper;
    @Resource
    ClientService clientService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/skp")
    public String skip() {
        return "regist";
    }

    @MyAnnotation
    @RequestMapping("/regist")
    public String reg(@RequestParam("userName") String userName, @RequestParam("passWrod") String passWrod,
                      @RequestParam("userPhone") String userPhone,
                      HttpServletRequest request) {
        boolean b = false;
        String pwd = MD5.getMD5String(passWrod);
        b = usermapper.insert(userName, pwd, userPhone);
        if (b) {
            request.getSession().setAttribute("loginMessage", "注册成功,请登录！");
            return "login";
        }
        request.getSession().setAttribute("registMessage", "请输入正确的手机号码");
        return "regist";

    }

    @RequestMapping("/home")
    public String home(@RequestParam("userName") String userName, @RequestParam("passWrod") String passWrod,
                       HttpServletRequest request) {
        String psd = MD5.getMD5String(passWrod);
        // 若不new 则会出现空指针异常
        User user = new User();
        user = usermapper.selectUser(userName, psd);
        if (user == null) {
            request.getSession().setAttribute("loginMessage", "用户名或密码错误!");
            return "login";

        } else {
            List<ClientDO> listAllClient = clientService.ListAllClient();
            request.getSession().setAttribute("userName", userName);
            request.getSession().setAttribute("LOGINUSER", new User(userName, passWrod));
            request.getSession().setAttribute("AllUser", listAllClient);
            return "index";
        }

    }

    @RequestMapping("/exit")
    public String home(HttpServletRequest request) {
        //  清空session
        request.getSession().invalidate();
        return "login";
    }

}
