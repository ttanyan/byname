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
 * 2019/4/14    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import com.dlnu.byname.domain.entity.RolePermissionDO;
import com.dlnu.byname.mapper.RolePermissionMapper;
import com.dlnu.byname.services.RolePermissionService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 14:25
 */
public class RolePermissionTest extends BaseTest {
    @Resource
    RolePermissionMapper rolePermissionMapper;
    @Resource
    RolePermissionService rolePermissionService;
    @Test
    public void insertRolePermissionTest(){
        //权限 2，3，4 角色  3 4 5
        RolePermissionDO rolePermissionDO = new RolePermissionDO();
//        for (Long i = 2L; i < 5L; i++) {
            rolePermissionDO.setPermissionId(8L);
            rolePermissionDO.setRoleId(90L);
            rolePermissionMapper.insert(rolePermissionDO);

//        }
    }
    @Test
    public void deleteRolePermissionTest(){
        List<RolePermissionDO> list = new ArrayList<>();
        for(long i = 102;i<120;i++){
            RolePermissionDO rolePermissionDO = new RolePermissionDO();
            rolePermissionDO.setRoleId(100L);
            rolePermissionDO.setPermissionId(i);
            list.add(rolePermissionDO);
        }
        rolePermissionMapper.delete(list);
    }
    @Test
    public void getRolePermissionTest(){
        List<RolePermissionDO> list = rolePermissionMapper.get(5L);
        list.forEach(rp->{
            logger.info("角色 "+rp.getRoleId()+"权限 "+rp.getPermissionId());
        });
    }
    @Test
    public void listRolePermissionTest(){
        List<RolePermissionDO> list = rolePermissionMapper.list();
        list.forEach(rp->{
            logger.info("角色 "+rp.getRoleId()+"权限 "+rp.getPermissionId());
        });
    }
    @Test
    public void listByRoleIdTest(){
        List<RolePermissionDO> list = rolePermissionService.listByRoleId(5L);
        list.forEach(p->{
            logger.info("角色 "+p.getRoleId()+"权限 "+p.getPermissionId());
        });
    }
    @Test
    public void batchInsertTest(){
        List<RolePermissionDO> list = new ArrayList<>();
        for(long i = 102;i<120;i++){
            RolePermissionDO rolePermissionDO = new RolePermissionDO();
            rolePermissionDO.setRoleId(100L);
            rolePermissionDO.setPermissionId(i);
            list.add(rolePermissionDO);
        }
        rolePermissionMapper.batchInsert(list);
    }

}
