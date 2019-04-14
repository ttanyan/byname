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
     * 用户注册
     * @return int 成功-1，失败-0
     * @author  Tanlianwang
     * @date 2019/4/13 16:30
     */
     int addUser(UserDO userDO);
     /**
      * 查询单个用户信息
      * @return UserDO {@link UserDO}
      * @author  Tanlianwang
      * @date 2019/4/14 15:01
      */
     UserDO getUser(String number);

}
