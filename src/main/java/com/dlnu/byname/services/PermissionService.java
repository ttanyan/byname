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


package com.dlnu.byname.services;

import com.dlnu.byname.domain.bo.UserPermissionBO;
import com.dlnu.byname.domain.entity.PermissionDO;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/14 15:19
 */
public interface PermissionService {
  /** 
   * 根据用户number查找角色权限以及URL
   * @param number  用户编码
   * @return java.util.Set&lt;java.lang.String&gt;
   * @author  Tanlianwang
   * @date 2019/4/14 17:32
   */ 
    Set<UserPermissionBO> listByUserNumber(String number);
    /**
     * 判断url是否需要拦截 true:需要拦截 false:不要拦截
     * @param url url地址
     * @return java.util.List&lt;com.dlnu.byname.domain.entity.PermissionDO&gt;
     * @author  Tanlianwang
     * @date 2019/4/14 20:59
     */
    Boolean needInterceptor(String url);


}
