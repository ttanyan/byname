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
 * 2019/6/2      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.controller.permission;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.constant.JsonResult;
import com.dlnu.byname.domain.entity.RoleDO;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.domain.entity.UserRoleDO;
import com.dlnu.byname.services.UserRoleService;
import com.dlnu.byname.services.UserService;
import com.dlnu.byname.util.ClassUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/6/2 22:57
 */
@RestController
@RequestMapping("config")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    /**
     * 状态结果
     */
    int sign = CommonConstant.RESULT_STATUS_FAIL;

    @RequestMapping("insertUser")
    public JsonResult<List> insertUser(@RequestBody UserDO userDO) {
        if (ClassUtils.ObjIsNotNull(userDO)) {
            //初始密码设置
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            String encodedPassword = new SimpleHash(CommonConstant.ENCRYPTION_METHOD, CommonConstant.INIT_PASSWORD, salt, CommonConstant.ENCRYPTION_TIME).toString();
            userDO.setSalt(salt);
            userDO.setPassword(encodedPassword);
            sign = userService.addUser(userDO);
            if (sign != CommonConstant.RESULT_STATUS_FAIL) {
                return new JsonResult<>("添加用户成功");
            }
        }
        return new JsonResult<>("添加用户失败");
    }

    @RequestMapping("addUserRole")
    public JsonResult<List> addUserRole(@RequestBody List<RoleDO> list, Long userId) {
        List<UserRoleDO> urList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(p -> {
                UserRoleDO userRoleDO = new UserRoleDO();
                userRoleDO.setRoleId(p.getId());
                userRoleDO.setUserId(userId);
                urList.add(userRoleDO);
            });
        }
        int sign = userRoleService.batchInsert(urList);
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("未选择新的角色 ！");
        } else {
            return new JsonResult<>("成功关联" + sign + "个角色！");
        }

    }


    @RequestMapping("deleteUser")
    public JsonResult<List> deleteUser(@RequestBody List<UserDO> list) {
        if (!list.isEmpty()) {
            sign = userService.deleteUser(list);
            if (sign != CommonConstant.RESULT_STATUS_FAIL) {
                return new JsonResult<>("成功删除" + sign + "条!");
            }
        }
        return new JsonResult<>("未选择");

    }

    @RequestMapping("deleteUserRole")
    public JsonResult<List> deleteRolePermission(@RequestBody List<RoleDO> list, Long userId) {

        List<UserRoleDO> urList = new ArrayList<>();
        if (!list.isEmpty()) {
            list.forEach(p -> {
                UserRoleDO userRoleDO = new UserRoleDO();
                userRoleDO.setRoleId(p.getId());
                userRoleDO.setUserId(userId);
                urList.add(userRoleDO);
            });
        }
        int sign = userRoleService.batchDelete(urList);
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("未选择取消的角色！");
        } else {
            return new JsonResult<>("成功取消" + sign + "个角色！");
        }
    }

    @RequestMapping("updateUser")
    public JsonResult<List> updateUser(@RequestBody UserDO userDO) {
        //TODO 添加邮箱以及号码的格式验证
        if (ClassUtils.ObjIsNotNull(userDO)) {
            sign = userService.updateUser(userDO);
        }
        if (sign == CommonConstant.RESULT_STATUS_FAIL) {
            return new JsonResult<>("修改失败");
        } else {
            return new JsonResult<>("修改成功");
        }

    }

    @RequestMapping(value = "listUser",method = RequestMethod.GET)
    public JsonResult<List<UserDO>> listUser(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<UserDO> userDOList = userService.listUser();
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOList);
        return new JsonResult<>((List<UserDO>)userDOList,pageInfo.getTotal());
    }

    @RequestMapping("selectKeyUser")
    public JsonResult<List<UserDO>> selectKeyRole(int page, int limit, String keyWord) {
        PageHelper.startPage(page, limit);
        List<UserDO> userDOList = userService.selectKeyUser(keyWord);
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOList);
        return new JsonResult<>((List<UserDO>)userDOList,pageInfo.getTotal());
    }
}
