/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
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
 * 2018/12/26    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import com.dlnu.byname.domain.entity.UserDO;
import com.dlnu.byname.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 13:42
 */

public class UserTest extends  BaseTest{
    @Resource
    private UserMapper userMapper;

    @Test
    public void insertUserTest(){
        UserDO userDO = new UserDO();
        userDO.setNumber("2015132118");
        userDO.setName("小明");
        userDO.setCollege("物联151");
        userDO.setMajory("信息与通信工程专业");
        userDO.setEmail("1075379406@qq.com");
        userDO.setPassword("123124");
        userDO.setSex("女");
        userDO.setTel("13029409628");
        userDO.setSalt("4343");
        userMapper.insert(userDO);
    }
    @Test
    public void deleteUserTest(){
        userMapper.delete("2015132111");
    }
    @Test
    public void updateUserTest(){
        UserDO userDO = new UserDO();
        userDO.setNumber("2015132111");
        userDO.setName("笑话");
        userDO.setCollege("文学院");
//       int i =  userMapper.update(userDO);
       userMapper.update(userDO);
    }
    @Test
    public void getUserTest(){

        UserDO userDO = userMapper.get("2015132114");
       logger.info(userDO.getName()+userDO.getId());
    }
    @Test
    public void listUserTest(){
        List<UserDO> listUser = userMapper.listUser();
        listUser.forEach(p ->{
            logger.info(p.getName());

        });
    }



}
