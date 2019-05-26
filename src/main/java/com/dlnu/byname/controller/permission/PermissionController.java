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
import com.dlnu.byname.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/4/24 9:08
 * 实现权限、角色、用户的增删改查
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
    public JsonResult<List> getListPermission(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<PermissionDO> permissionDOList = permissionService.listPermission();
        int count = permissionService.getCount();
        PageBean<PermissionDO> pageData = new PageBean<>(page, limit, count);
        pageData.setItems(permissionDOList);
        return new JsonResult<>(pageData.getItems(), count);
    }

    @RequestMapping("selectKeyPermission")
    public JsonResult<List> selectPermission(int page, int limit, String keyWord) {
        //TODO 需要优化查询总数 目前是查了两遍
        int count = CommonConstant.RESULT_STATUS_FAIL;
        List<PermissionDO> permissionDOKeyListOne = permissionService.selectKeyPermission(keyWord);
        //统计查询结果总数
        count = permissionDOKeyListOne.size();
        PageHelper.startPage(page, limit);
        List<PermissionDO> permissionDOKeyList = permissionService.selectKeyPermission(keyWord);
        PageBean<PermissionDO> pageData = new PageBean<>(page, limit, count);
        pageData.setItems(permissionDOKeyList);
        return new JsonResult<>(pageData.getItems(), count);
    }


}
