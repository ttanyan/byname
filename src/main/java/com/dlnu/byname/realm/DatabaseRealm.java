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
 * 2019/4/10    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.realm;

import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.services.RolePermissionService;
import com.dlnu.byname.services.RoleService;
import com.dlnu.byname.services.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/10 20:14
 */
public class DatabaseRealm extends AuthorizingRealm {
    @Resource
    RoleService roleService;
    @Resource
    PermissionService permissionService;
    @Resource
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入到这里，表示账号已经通过验证了
        String number = (String) principalCollection.getPrimaryPrincipal();
        // 通过service获取角色和权限
        Set<String> roles = roleService.listRoleName(number);
        Set<UserPermissionBO> userPermissionBO = permissionService.listByUserNumber(number);
        //通过迭代将权限名称提取出来
        Set<String> permissions = new HashSet<>();
        Iterator it = userPermissionBO.iterator();
        while (it.hasNext()) {
            UserPermissionBO str = (UserPermissionBO) it.next();
            permissions.add(str.getPermissionName());
        }
        // 授权对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 把通过service获取到的角色和权限放进去
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户编号
        String number = token.getPrincipal().toString();
        // 获取数据库中的密码
        UserDO user = userService.getUser(number);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        // 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        // 盐也放进去
        // 这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        SimpleAuthenticationInfo sign = new SimpleAuthenticationInfo(number, passwordInDB,
                ByteSource.Util.bytes(salt), getName());
        return sign;
    }
}
