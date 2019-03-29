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
 * 2018年12月16日    TanLianWang         Create the class
 * http://www.jimilab.com/
*/

package com.jimi.atm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jimi.atm.domain.entity.User;

/**
 * @FileName UserMapper.java
 * @Description:
 *
 * @Date 2018年12月16日 下午9:32:05
 * @author TanLianWang
 * @version 1.0
 */
public interface UserMapper {
    /**
     * 登录查询
     */
    @Select("SELECT name,password FROM user WHERE name = #{name} AND password=#{password}")
    public User selectUser(@Param("name") String name, @Param("password") String password);

    @Select("SELECT name,password FROM user")
    public List<User> selectAllUser();

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);

    @Update("UPDATE user SET name = #{name}, password = #{password} WHERE id = #{id}")
    void update(User User);

    @Insert("INSERT INTO user(name, password,phone) VALUES(#{name}, #{password},#{phone})")
    public boolean insert(@Param("name") String userName, @Param("password") String password,
                          @Param("phone") String userPhone);
}
