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


package com.dlnu.byname.mapper;

import com.dlnu.byname.domain.entity.UserDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/11 10:23
 */
public interface UserMapper {

    /**
     * 新增用户
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 更新用户
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 获取单个用户
     * @param id
     * @return
     */
    UserDO get(Integer id);

    /**
     * 获取所有用户
     * @return
     */
    List<UserDO> listUser();



}
