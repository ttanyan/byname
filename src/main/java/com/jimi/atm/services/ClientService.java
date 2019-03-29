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


package com.jimi.atm.services;

import com.jimi.atm.domain.entity.ClientDO;

import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 20:24
 * 提供给外部调用的接口 由ServiceImpl实现
 */
public interface ClientService {
    /**
     * 客户根据身份证以及密码进行登录
     * @param clientIdNumber
     * @param passWord
     * @return
     */
    ClientDO loginClient(String clientIdNumber, String passWord);


    /**
     * 客户注册
     * @param clientIdNumber
     * @param clientName
     * @param clientPhone
     * @param clientAccount
     * @param clientPassword
     * @return
     */
    boolean regist(String clientIdNumber,String clientName,String clientPhone,String clientAccount,String clientPassword);


    String selectMoney(String clientIdNumber);
    /**
     * 存取钱
     * @param clientMoney
     * @param clientIdNumber
     * @return
     */
    boolean addMoney(String clientMoney,String clientIdNumber);


    List<ClientDO> ListAllClient();


}
