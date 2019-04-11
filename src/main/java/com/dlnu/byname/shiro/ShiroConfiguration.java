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

import com.dlnu.byname.filter.URLPathMatchingFilter;
import com.dlnu.byname.realm.DatabaseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;
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

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 默认寻找login
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后跳转
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 权限未通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizdurl");
        // 拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //自定义拦截器
        Map<String, Filter>  customizationFilter = new HashMap<>();
        customizationFilter.put("url",getURLPathMatchingFilter());

        /**
         * 配置映射关系
         * anon 表示不需要任何权限都可以访问
         */
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/resources/**","anon");
        shiroFilterFactoryBean.setFilters(customizationFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * URLPathMatchingFilter 并没有用@Bean管理起来。
     * 原因是Shiro的bug, 这个也是过滤器，ShiroFilterFactoryBean 也是过滤器，
     * 当他们都出现的时候，默认的什么anno,authc,logout过滤器就失效了。
     * 所以不能把他声明为@Bean。
     */

    public URLPathMatchingFilter getURLPathMatchingFilter(){
        return new URLPathMatchingFilter();
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
//        myShiroRealm.setCreadn
        return myShiroRealm;
    }

    /**
     * 设置密码校验方式
     * @return  hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
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
