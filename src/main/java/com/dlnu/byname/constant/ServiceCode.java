/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2020.
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
 * 2020/12/20    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.constant;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/12/20 下午11:55
 */
public enum ServiceCode {
    PERMISSION(1),
    ROLE(2),
    USER(3);


    private int code;

    ServiceCode(int code) {
        this.code = code;
    }
}
