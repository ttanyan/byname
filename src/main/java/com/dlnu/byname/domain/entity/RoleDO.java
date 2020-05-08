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
 * 2019/4/12    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.domain.entity;

import com.dlnu.byname.common.BaseDO;

import java.util.StringJoiner;

/**
 * 角色实体类
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/12 15:12
 */
public class RoleDO extends BaseDO {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RoleDO.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("desc='" + note + "'")
                .toString();
    }
}
