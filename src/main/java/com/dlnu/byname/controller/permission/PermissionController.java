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

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.PermissionDO;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.util.ClassUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Permission;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description 实现权限、角色、用户的增删改查
 * @Date 2019/4/24 9:08
 */
@RestController
@RequestMapping("config")
public class PermissionController {
    @Resource
    PermissionService permissionService;
    /**
     * 结果状态
     */
    int sign = CommonConstant.RESULT_STATUS_FAIL;

    @RequestMapping("insertPermission")
    public JsonResult<List> insertPermission(@RequestBody PermissionDO permissionDO) {

        if (ClassUtils.ObjIsNotNull(permissionDO)) {
            sign = permissionService.insertPermission(permissionDO);
            if (sign == CommonConstant.RESULT_STATUS_SUCCESS) {
                return new JsonResult<>("添加成功!");
            } else {
                return new JsonResult<>("添加失败!");
            }
        } else {
            return new JsonResult<>("添加失败!");
        }

    }

    @RequestMapping("deletePermission")
    public JsonResult<List> deletePermission(@RequestBody List<PermissionDO> list) {
        //判断是否选择
        if (list.isEmpty()) {
            return new JsonResult<>("未勾选！");
        }
        sign = permissionService.deletePermission(list);
        //判断是否已经删除
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("不存在！");
        }
        return new JsonResult<>("成功删除"+sign+"条!");
    }

    @RequestMapping("updatePermission")
    public JsonResult<List> updatePermission(@RequestBody PermissionDO permissionDO) {
        if (permissionDO.getId() != null) {
            permissionService.updatePermission(permissionDO);
            return new JsonResult<>("修改成功！");
        } else {
            return new JsonResult<>("修改信息不存在！");
        }
    }

    @RequestMapping("listPermission")
    public JsonResult<List<PermissionDO>> getListPermission(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<PermissionDO> permissionDOList = permissionService.listPermission();
        PageInfo<PermissionDO> pageInfo = new PageInfo<>(permissionDOList);
        return new JsonResult<>(permissionDOList,pageInfo.getTotal());
    }

    @RequestMapping("selectKeyPermission")
    /**
     *
     *SpringMVC在接受参数的时候，如果不存在，那么会将这个值设置为null，如果你用基本数据类型，就无法设置为null
     */
    public JsonResult<List<PermissionDO>> selectPermission(int page, int limit, String keyWord) {
        PageHelper.startPage(page, limit);
        List<PermissionDO> PermissionDOKeyList = permissionService.selectKeyPermission(keyWord);
        PageInfo<PermissionDO> pageInfo = new PageInfo<>(PermissionDOKeyList);
        return new JsonResult<>(PermissionDOKeyList,pageInfo.getTotal());
    }


}
