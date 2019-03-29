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

package com.jimi.atm.domain.entity;

import java.util.StringJoiner;

/**
 * @FileName User.java
 * @Description:
 *
 * @Date 2018年12月16日 下午3:02:21
 * @author TanLianWang
 * @version 1.0
 */
public class User {

    /**
     * 用户姓名
     */
    private String name;
    /**
     * 密码
     */
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("passWord='" + passWord + "'")
                .toString();
    }

    public User(String name, String passWord) {
        super();

        this.name = name;
        this.passWord = passWord;
    }

    public User() {

    }

}
