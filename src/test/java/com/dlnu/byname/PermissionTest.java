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
 * 2019/4/12    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.domain.entity.PermissionDO;
import com.dlnu.byname.mapper.PermissionMapper;
import com.dlnu.byname.services.PermissionService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 19:33
 */
public class PermissionTest extends BaseTest{
    @Resource
    PermissionMapper permissionMapper;
    @Resource
    PermissionService permissionService;
    @Test
    public void insetPermissionTest(){
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setName("退出");
        permissionDO.setUrl("/logout");
        permissionMapper.insert(permissionDO);
    }
    @Test
    public void deletePermissionTest(){
        Integer i = permissionMapper.delete(1L);
        logger.info("result"+i);
    }
    @Test
    public void updatePermissionTest(){
        PermissionDO permissionDO = new PermissionDO();
        permissionDO.setName("登录");
        permissionDO.setId(2L);
    }
    @Test
    public void getPermissionTest(){
        PermissionDO permissionDO = permissionMapper.get(1L);
        logger.info(permissionDO.getGmtCreate()+"创建时间");
    }
    @Test
    public void listPermissionTest(){
        List<PermissionDO> permissionDOList = permissionMapper.listPermission();
        permissionDOList.forEach(p->{
            logger.info("权限名称"+p.getName()+"\n"+"创建时间"+p.getGmtCreate());
        });
    }
    @Test
    public void listByUserNumberTest(){
        Set<UserPermissionBO> listNumber = permissionService.listByUserNumber("2015132114");
        listNumber.forEach(p->{
            logger.info(p.toString());
        });
    }
    @Test
    public void getCount(){
        System.out.println(permissionMapper.getCount());
    }




}
