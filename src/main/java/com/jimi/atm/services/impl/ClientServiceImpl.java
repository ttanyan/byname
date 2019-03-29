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


package com.jimi.atm.services.impl;

import com.jimi.atm.domain.entity.ClientDO;
import com.jimi.atm.mapper.ClientMapper;
import com.jimi.atm.services.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 20:25
 * 对应的逻辑，使用Mapper里面基本的数据库操作实现Service对应的接口
 */
@Service
public class ClientServiceImpl implements  ClientService{
    @Resource
    ClientMapper clientMapper;

    /**用户登录
     * @param clientIdNumber
     * @param passWord
     * @return
     */
    @Override
    public ClientDO loginClient(String clientIdNumber, String passWord) {
            ClientDO clientDO = clientMapper.get(clientIdNumber,passWord);
            if(clientDO == null){
               return null;
            }else{
                return clientDO;
            }


    }


    /**
     * 注册账户
     * @param clientIdNumber
     * @param clientName
     * @param clientPhone
     * @param clientAccount
     * @param clientPassword
     * @return
     */
    @Override
    public boolean regist(String clientIdNumber, String clientName, String clientPhone, String clientAccount, String clientPassword) {
        boolean a = false;
        a = clientMapper.regist(clientIdNumber,clientName,clientPhone,clientAccount,clientPassword);
        return a;
    }

    /**
     * 客户余额查询
     * @param clientIdNumber
     * @return
     */
    @Override
    public String selectMoney(String clientIdNumber) {
        String money = "0";
        money = clientMapper.selectMoney(clientIdNumber);
        return money;
    }

    /**
     * 存钱操作
     * @param clientMoney  存入金额
     * @param clientIdNumber  身份证号码
     * @return
     */
    @Override
    public boolean addMoney(String clientMoney, String clientIdNumber) {
        boolean a = false;
               a = clientMapper.addMoney(clientMoney,clientIdNumber);
        return a;
    }

    @Override
    public List<ClientDO> ListAllClient() {
        List<ClientDO> list = clientMapper.ListAllClient();
        return  list;
    }
}
