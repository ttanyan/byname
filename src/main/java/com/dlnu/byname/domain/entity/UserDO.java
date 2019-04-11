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
 * 2019/4/10    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.domain.entity;

import com.dlnu.byname.common.BaseDO;

import java.util.StringJoiner;

/**
 * 用户实体类
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/10 17:44
 */
public class UserDO extends BaseDO {
    /**
     * 编码
     */
    private String number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String majory;
    /**
     * 性别：2-表示其他 ，1-表示男生， 0-表示女生
     */
    private Boolean sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String tel;
    /**
     * 密码
     */
    private String password;
    /**
     * 密钥
     */
    private String salt;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajory() {
        return majory;
    }

    public void setMajory(String majory) {
        this.majory = majory;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDO.class.getSimpleName() + "[", "]")
                .add("number='" + number + "'")
                .add("name='" + name + "'")
                .add("college='" + college + "'")
                .add("majory='" + majory + "'")
                .add("sex=" + sex)
                .add("email='" + email + "'")
                .add("tel='" + tel + "'")
                .add("password='" + password + "'")
                .add("salt='" + salt + "'")
                .toString();
    }
}
