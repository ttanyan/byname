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
 * 2019/4/11    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.services;

import com.dlnu.byname.domain.entity.UserDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/11 16:45
 */

public interface UserService {
    /**
     * 增加 add
     * 删除 delete
     * 修改 update
     * 查询 get list
     */
    /**
     * 增加用户 -注册
     * @param userDO {@link UserDO}
     * @return  影响条数
     */
     int addUser(UserDO userDO);

    /**
     * 批量删除用户
     * @param list 用户集合
     * @return 删除个数
     */
     int deleteUser(List<UserDO> list);

    /**
     * 修改用户信息
     * @param userDO {@link UserDO}
     * @return 影响条数
     */
     int updateUser(UserDO userDO);

    /**
     * 根据用户编号获取用户信息
     * @param number 用户编号
     * @return {@link UserDO}
     */
     UserDO getUser(String number);

    /**
     * 获取所有用户信息
     * @return 用户信息
     */
     List<UserDO> listUser();

    /**
     * 根据关键字搜索用户信息
     * @param keyWord 关键字
     * @return {@link UserDO}
     */
    List<UserDO> selectKeyUser(String keyWord);
    /**
     * 获取用户数量
     * @return 数量
     */
    Integer getCount();

}
