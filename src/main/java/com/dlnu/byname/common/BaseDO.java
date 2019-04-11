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


package com.dlnu.byname.common;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2019/4/11 10:15
 */
public class BaseDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseDO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModified=" + gmtModified)
                .toString();
    }
}
