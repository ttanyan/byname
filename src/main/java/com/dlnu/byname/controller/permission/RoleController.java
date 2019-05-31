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
 * 2019/5/26      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.controller.permission;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.PermissionDO;
import com.dlnu.byname.domain.entity.RoleDO;
import com.dlnu.byname.domain.entity.RolePermissionDO;
import com.dlnu.byname.services.RolePermissionService;
import com.dlnu.byname.services.RoleService;
import com.dlnu.byname.util.ClassUtils;
import com.dlnu.byname.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/5/26 0:30
 * 实现角色的基本操作以及与权限的关联
 */
@RestController
@RequestMapping("/config")
public class RoleController {
    @Resource
    RolePermissionService rolePermissionService;
    @Resource
    RoleService roleService;
    /**
     * 状态结果
     */
    int sign = CommonConstant.RESULT_STATUS_FAIL;


    @RequestMapping("insertRole")
    public JsonResult<List> insertRole(@RequestBody RoleDO roleDO) {
        if (ClassUtils.ObjIsNotNull(roleDO)) {
            roleService.insertRole(roleDO);
            return new JsonResult<>();
        }
        return new JsonResult<>("操作失败！");
    }

    @RequestMapping("addRolePermission")
    public JsonResult<List> addRolePermission(@RequestBody List<PermissionDO> list, Long roleId) {

        List<RolePermissionDO> rpList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(p -> {
                RolePermissionDO rolePermissionDO = new RolePermissionDO();
                rolePermissionDO.setPermissionId(p.getId());
                rolePermissionDO.setRoleId(roleId);
                rpList.add(rolePermissionDO);
            });
        }
        int sign = rolePermissionService.batchInsertByRolePermission(rpList);
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("未选择新的权限！");
        } else {
            return new JsonResult<>("成功关联" + sign + "个权限！");
        }

    }

    @RequestMapping("deleteRole")
    public JsonResult<List> deleteRole(@RequestBody List<RoleDO> list) {
        if (!list.isEmpty()) {
            sign = roleService.deleteRole(list);
            return new JsonResult<>("成功删除" + sign + "条!");
        } else {
            return new JsonResult<>("未选择");
        }
    }

    @RequestMapping("deleteRolePermission")
    public JsonResult<List> deleteRolePermission(@RequestBody List<RolePermissionDO> list, Long roleId) {

        List<RolePermissionDO> rpList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(p -> {
                RolePermissionDO rolePermissionDO = new RolePermissionDO();
                rolePermissionDO.setPermissionId(p.getId());
                rolePermissionDO.setRoleId(roleId);
                rpList.add(rolePermissionDO);
            });
        }
        int sign = rolePermissionService.batchDeleteByRolePermission(rpList);
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("未选择取消的权限！");
        } else {
            return new JsonResult<>("成功取消" + sign + "个权限！");
        }
    }

    @RequestMapping("updateRole")
    public JsonResult<List> updateRole(@RequestBody RoleDO roleDO) {
        if (ClassUtils.ObjIsNotNull(roleDO)) {
            roleService.updateRole(roleDO);
            return new JsonResult<>();
        }
        return new JsonResult<>("修改失败");
    }

    @RequestMapping("listRole")
    public JsonResult<List> getListRole(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<RoleDO> roleDOList = roleService.listRole();
        int count = roleService.getCount();
        PageBean<RoleDO> pageData = new PageBean<>(page, limit, count);
        pageData.setItems(roleDOList);
        return new JsonResult<>(pageData.getItems(), count);
    }

    @RequestMapping("selectKeyRole")
    public JsonResult<List> selectKeyRole(int page, int limit, String keyWord) {
        //TODO 需要优化查询总数 目前是查了两遍
        List<RoleDO> roleDOListOne = roleService.selectKeyRole(keyWord);
        int count = roleDOListOne.size();
        PageHelper.startPage(page, limit);
        List<RoleDO> roleDOList = roleService.selectKeyRole(keyWord);
        PageBean<RoleDO> pageData = new PageBean<>(page, limit, count);
        pageData.setItems(roleDOList);
        return new JsonResult<>(pageData.getItems(), count);
    }
}
