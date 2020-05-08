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

import com.dlnu.byname.domain.entity.UserRoleDO;
import com.dlnu.byname.mapper.UserRoleMapper;
import com.dlnu.byname.services.UserRoleService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 13:29
 */

public class UserRoleTest extends BaseTest{
    @Resource
    UserRoleMapper userRoleMapper;
    @Resource
    UserRoleService userRoleService;


    @Test
    public void insertUserRoleTest(){
        UserRoleDO userRoleDO = new UserRoleDO();
        //user 1 6 8 10 role 3 4 5
        for(Long i = 3L;i<5L;i++) {
            userRoleDO.setRoleId(i);
            userRoleDO.setUserId(8L);
            userRoleMapper.insert(userRoleDO);
        }

    }
    @Test
    public void deleteUserRoleTest(){
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setRoleId(1L);
        userRoleDO.setUserId(2L);
        userRoleMapper.delete(userRoleDO);
    }
    @Test
    public void getUserRoleTest(){
        List<UserRoleDO> userRoleDOList = userRoleMapper.get(10L);
        for(UserRoleDO u:userRoleDOList){
            logger.info("roleId:"+u.getRoleId()+"  userId"+u.getUserId());
        }
    }
    @Test
    public void listUserRoleTest(){
        List<UserRoleDO> list = userRoleMapper.list();
       list.forEach(u -> {
           logger.info("roleId:"+u.getRoleId()+"  userId"+u.getUserId());
       });

    }
    @Test
    public void listByNumber(){
        List<UserRoleDO> listUserRole = userRoleService.listUserRole("2015132130");
        listUserRole.forEach(p->{
            logger.info("roleId:"+p.getRoleId()+"  userId"+p.getUserId());
        });

    }


}
