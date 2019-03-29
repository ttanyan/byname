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


package com.jimi.atm.mapper;

import com.jimi.atm.domain.entity.ClientDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 10:15
 */

public interface ClientMapper {


    /**
     * 管理员查询所有的用户信息
     * @return
     */
    List<ClientDO> ListAllClient();

    /**
     * 管理员删除用户
     * @return
     */
       void  deleteClient(@Param("clientIdNumber") String clientIdNumber );

    /**
     * 返回ClientDO对象
     * @param clientIdNumber
     * @param clientPassword
     * @return
     */
       ClientDO get(@Param("clientIdNumber") String clientIdNumber,@Param("clientPassword") String clientPassword);
    /**
     *客户根据身份证号码修改姓名或者密码
     * @return
     */
    void updateClient(@Param("clientIdNumber") String clientIdNumber,@Param("clientName") String clientName,@Param("clientPassword") String clientPassword);


    /**
     * 客户注册
     * @param clientIdNumber
     * @param clientName
     * @param clientPhone
     * @param clientAccount
     * @param clientPassword
     * @return
     */
    Boolean regist(@Param("clientIdNumber") String clientIdNumber,@Param("clientName") String clientName,
                   @Param("clientPhone") String clientPhone,@Param("clientAccount") String clientAccount,@Param("clientPassword") String clientPassword);


    /**
     * 客户查询余额接口
     * @return
     */
    String selectMoney(@Param("clientIdNumber") String clientIdNumber);

    /**
     * 存取钱
     * @param clientMoney
     * @param clientIdNumber
     * @return
     */
    Boolean addMoney(@Param("clientMoney") String clientMoney,@Param("clientIdNumber")  String clientIdNumber);

}
