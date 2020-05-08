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

import com.dlnu.byname.domain.entity.RoleDO;
import com.dlnu.byname.mapper.RoleMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 16:37
 */
public class RoleTest extends BaseTest {
    @Resource
    RoleMapper roleMapper;
    @Test
    public void insertRoleTest(){
        RoleDO roleDO = new RoleDO();
        roleDO.setName("管理员");
        roleDO.setNote("具有所有的权限");
        for(int i = 0;i<300;i++) {
            int sign = roleMapper.insert(roleDO);
        }
//        logger.info("结果"+sign);
    }
    @Test
    public void deleteRoleTest(){
//        roleMapper.delete();

    }
    @Test
    public void updateRoleTest(){
        RoleDO roleDO = new RoleDO();
        roleDO.setName("教师");
        roleDO.setNote("具备选课点名的权限");
        roleDO.setId(3L);
        roleMapper.update(roleDO);
    }
    @Test
    public void getRoleTest(){
        RoleDO  roleDO = roleMapper.get(3L);
        logger.info(roleDO.getName());
    }
    @Test
    public void listRoleTest(){
       List<RoleDO> roleDOList =  roleMapper.listRole();
       roleDOList.forEach(p->{
           logger.info(p.getName()+"\n"+"时间"+p.getGmtCreate());
       });
    }
    @Test
    public void listByUserNumber(){
        Set<String> listRoleName = roleMapper.listByUserNumber("2015132130");
        listRoleName.forEach(p->{
            logger.info(p.toString());
        });
    }
}
