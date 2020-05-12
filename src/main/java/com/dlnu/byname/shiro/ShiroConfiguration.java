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


package com.dlnu.byname.shiro;

import com.dlnu.byname.constant.CommonConstant;
import com.dlnu.byname.filter.UrlPathMatchingFilter;
import com.dlnu.byname.realm.DatabaseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultLifecycleProcessor;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/10 18:13
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleProcessor getLifecycleProcessor(){
        return  new DefaultLifecycleProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        System.out.println("--------------------------------------ShiroConfiguration.shirFilter()初始化---------------------------------");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 登录成功
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后跳转
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 权限未通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizdurl");
        // 拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //自定义拦截器 拦截名为url 拦截方法为getUrlPathMatchingFilter
        Map<String, Filter>  customizationFilter = new HashMap<>();
        customizationFilter.put("url",getUrlPathMatchingFilter());

        /**
         * 配置映射关系
         * anon 表示不需要任何权限都可以访问
         */
        /**
         * anon---------------org.apache.shiro.web.filter.authc.AnonymousFilter 没有参数，表示可以匿名使用。
         * authc--------------org.apache.shiro.web.filter.authc.FormAuthenticationFilter 表示需要认证(登录)才能使用，没有参数
         * authcBasic---------org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter 没有参数表示httpBasic认证
         * logout-------------org.apache.shiro.web.filter.authc.LogoutFilter
         * noSessionCreation--org.apache.shiro.web.filter.session.NoSessionCreationFilter
         * perms--------------org.apache.shiro.web.filter.authz.PermissionAuthorizationFilter 参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
         * port---------------org.apache.shiro.web.filter.authz.PortFilter port[8081],当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
         * rest---------------org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter 根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。
         * roles--------------org.apache.shiro.web.filter.authz.RolesAuthorizationFilter 参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
         * ssl----------------org.apache.shiro.web.filter.authz.SslFilter 没有参数，表示安全的url请求，协议为https
         * user---------------org.apache.shiro.web.filter.authz.UserFilter 没有参数表示必须存在用户，当登入操作时不做检查
         */

        filterChainDefinitionMap.put("/Tanlianwang","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/byname","anon");
        filterChainDefinitionMap.put("/register","anon");
        filterChainDefinitionMap.put("/jump-register","anon");
        filterChainDefinitionMap.put("/Tanlianwang","anon");
        filterChainDefinitionMap.put("/unauthorized","anon");
        filterChainDefinitionMap.put("/resources/**","anon");
        //其他请求都需通过自定义拦截器去处理
 //      filterChainDefinitionMap.put("/**","url");
        shiroFilterFactoryBean.setFilters(customizationFilter);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * UrlPathMatchingFilter 并没有用@Bean管理起来。
     * 原因是Shiro的bug, 这个也是过滤器，ShiroFilterFactoryBean 也是过滤器，
     * 当他们都出现的时候，默认的什么anno,authc,logout过滤器就失效了。
     * 所以不能把他声明为@Bean。
     */
    public UrlPathMatchingFilter getUrlPathMatchingFilter(){
        return new UrlPathMatchingFilter();
    }
    @Bean
    public SecurityManager securityManager(){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //shiro验证的核心 设置realm
        securityManager.setRealm(getDatabaseRealm());
        return  securityManager;
    }
    @Bean
    public DatabaseRealm getDatabaseRealm(){
        DatabaseRealm myShiroRealm = new DatabaseRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 设置密码校验方式
     * @return  hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(CommonConstant.ENCRYPTION_METHOD);
        hashedCredentialsMatcher.setHashIterations(CommonConstant.ENCRYPTION_TIME);
        return  hashedCredentialsMatcher;
    }

    /**
     * 开启 shiro 注解支持
     * @param securityManager
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return  authorizationAttributeSourceAdvisor;
    }

}
