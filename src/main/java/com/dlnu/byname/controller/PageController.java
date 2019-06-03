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
 * 2019/4/24      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.controller;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.RolePermissionDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.services.RolePermissionService;
import com.dlnu.byname.services.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/4/24 8:55
 * 页面控制
 */
@Controller
@RequestMapping("")
public class PageController {
    @Resource
    RolePermissionService rolePermissionService;
    @Resource
    UserRoleService userRoleService;

    @RequestMapping(value = "byname")
    public ModelAndView jumpLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "jump-register")
    public String jumpRegister() {
        return "register";
    }

    @RequestMapping("jump-listPermission")
    public String jumpListPermission() {
        return "listPermission";
    }

    @RequestMapping("jump-listRole")
    public String jumpListRole() {
        return "listRole";
    }

    @RequestMapping("jump-popupsPermission")
    public String jumpPopupsPermission(Model model,Long roleId) {
        //传递角色id到弹出界面，然后传到对应的控制层
        model.addAttribute("roleId",roleId);
        //获取指定角色id的PermissionId
        if(!roleId.equals(CommonConstant.EMPTY_STRING)){
            List<RolePermissionDO> list = rolePermissionService.getRolePermission(roleId);
            //转换为String数组
            List<Long> permissionIds = new ArrayList<>();
            list.forEach(p->{
                permissionIds.add(p.getPermissionId());
            });
            model.addAttribute("RolePermission",permissionIds);
        }else{
            model.addAttribute("RolePermission",null);
        }
        return "popupsPermission";
    }

    @RequestMapping("jump-listUser")
    public String jumpUser(){
        return "listUser";
    }

    @RequestMapping("jump-popupsRole")
    public String jumpPopupsRole(Model model,Long userId){
        model.addAttribute("userId",userId);
        if(!userId.equals(CommonConstant.EMPTY_STRING)){
            //TODO 判断list是否为空
            List<UserRoleDO> list = userRoleService.getUserRole(userId);
            //转换为String数组
            List<Long> roleIds = new ArrayList<>();
            list.forEach(p->{
                roleIds.add(p.getRoleId());
            });
            model.addAttribute("RoleIds",roleIds);
        }else{
            model.addAttribute("RoleIds",null);
        }
        return "popupsRole";
    }

}
