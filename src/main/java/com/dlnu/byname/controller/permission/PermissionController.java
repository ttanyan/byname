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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/4/24 9:08
 * 实现权限的增删改查
 */
@RestController
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
    public JsonResult<List> deletePermission(@RequestBody List<PermissionDO> list){
        //TODO 优化
        //将ID存放在Set数组中,其实可以不用Set，或者不进行提取，直接传递list即可
        Set<Long> setList = new HashSet<>();
        //增强for循环
        list.forEach(p->{
            setList.add(p.getId());
        });
        permissionService.deletePermission(setList);
        return new JsonResult<>();
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
    public JsonResult<List> getListPermission(int page,int limit){
        PageHelper.startPage(page,limit);
        List<PermissionDO> permissionDOList = permissionService.listPermission();
        int count = permissionMapper.getCount();
        PageBean<PermissionDO> pageData = new PageBean<>(page,limit,count);
        pageData.setItems(permissionDOList);
        return new JsonResult<>(pageData.getItems(), count);
    }


}
