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


package com.dlnu.byname.filter;

import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.services.PermissionService;
import com.dlnu.byname.util.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/10 19:54
 */
public class UrlPathMatchingFilter extends PathMatchingFilter {
    @Resource
    PermissionService permissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        if(null==permissionService) {
            permissionService = SpringContextUtils.getContext().getBean(PermissionService.class);
        }
        String requestURI = getPathWithinApplication(request);
        System.out.println("requestURI:" + requestURI);
        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
                WebUtils.issueRedirect(request, response, "/byname");
                return false;
        }
        // 判断访问的路径是否需要认证
        boolean needInterceptor = permissionService.needInterceptor(requestURI);
        //不需要认证--放行（可以考虑拦截？）
        if (!needInterceptor) {
            return true;
        } else {
            //需要优化逻辑
            boolean hasPermission = false;
            String number = subject.getPrincipal().toString();
            Set<UserPermissionBO> userPermissionBO = permissionService.listByUserNumber(number);

            //通过迭代将用户URL提取出来
            Set<String> permissionUrls = new HashSet<>();
            Iterator it = userPermissionBO.iterator();
            while (it.hasNext()) {
                UserPermissionBO str = (UserPermissionBO) it.next();
                permissionUrls.add(str.getPermissionURL());
            }

            //判断当前用户是否具有访问权限
            for (String url : permissionUrls) {
                if (url.equals(requestURI)) {
                    hasPermission = true;
                    break;
                }
            }
            if (hasPermission) {
                return true;
            }
            else {
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");
                subject.getSession().setAttribute("ex", ex);
                WebUtils.issueRedirect(request, response, "/unauthorized");
                System.out.println("这个是没有跳转的========================================");
                return false;
            }
        }

    }


}
