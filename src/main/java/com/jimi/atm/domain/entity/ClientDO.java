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


package com.jimi.atm.domain.entity;

import java.util.StringJoiner;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 9:48
 */
public class ClientDO {
    /**
     * 用户id
     */
    private  Long id;
    /**
     * 客户身份证号码
     */
    private  String clientIdNumber;
    /**
     * 手机号码
     */
    private String clientPhone;

    /**
     * 客户银行卡号
     */
    private String clientAccount;
    /**
     * 客户银行卡余额
     */
    private String clientMonye;
    /**
     * 客户姓名
     */
    private String clientName;
    /**
     * 客户密码
     */
    private String clientPassword;



    public String getClientIdNumber() {
        return clientIdNumber;
    }

    public void setClientIdNumber(String clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public String getClientMonye() {
        return clientMonye;
    }

    public void setClientMonye(String clientMonye) {
        this.clientMonye = clientMonye;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClientDO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("clientIdNumber='" + clientIdNumber + "'")
                .add("clientPhone='" + clientPhone + "'")
                .add("clientAccount=" + clientAccount)
                .add("clientMonye=" + clientMonye)
                .add("clientName='" + clientName + "'")
                .add("clientPassword='" + clientPassword + "'")
                .toString();
    }
}
