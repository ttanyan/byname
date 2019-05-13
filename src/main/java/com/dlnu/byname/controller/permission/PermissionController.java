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


package com.dlnu.byname.controller.permission;

import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.PermissionDO;
import com.dlnu.byname.mapper.PermissionMapper;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/4/24 9:08
 * 实现权限的增删改查
 */
@Controller
@RequestMapping("config")
public class PermissionController {
    @Resource
    PermissionService permissionService;
    @Resource
    PermissionMapper permissionMapper;

    @RequestMapping("insertPermission")
    public String insertPermission(Model model,PermissionDO permissionDO){
        if(permissionDO != null){
            permissionService.insertPermission(permissionDO);
            model.addAttribute("PermissionMessage","OK");
        }else{
            model.addAttribute("PermissionMessage","添加失败");
        }
        return "listPermission";
    }
    @RequestMapping("deletePermission")
    public String deletePermission(Model model,Long id){
        if(id != null) {
            permissionService.deletePermission(id);
            model.addAttribute("PermissionMessage", "OK");
        }else{
            model.addAttribute("PermissionMessage","删除失败");
        }
        return "listPermission";
    }
    @RequestMapping("updatePermission")
    public String updatePermission(Model model,PermissionDO permissionDO){
        if(permissionDO != null){
          permissionService.updatePermission(permissionDO);
          model.addAttribute("PermissionMessage","OK");
        }else{
            model.addAttribute("PermissionMessage","修改失败");
        }
        return "listPermission";
    }
    @RequestMapping("listPermission")
    @ResponseBody
    public JsonResult<List> getListPermission(int page,int limit){
        PageHelper.startPage(page,limit);
        List<PermissionDO> permissionDOList = permissionService.listPermission();
        int count = permissionMapper.getCount();
        PageBean<PermissionDO> pageData = new PageBean<>(page,limit,count);
        pageData.setItems(permissionDOList);
        return new JsonResult<>(pageData.getItems(), count);
    }


}
