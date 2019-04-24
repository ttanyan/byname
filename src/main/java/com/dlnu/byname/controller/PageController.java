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
 * 2019/4/24      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/4/24 8:55
 * 页面控制
 */
@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping(value = "byname")
    public String jumpLogin(){
        return "login";
    }

    @RequestMapping(value = "/jump-register")
    public String jumpRegister(){
        return "register";
    }
}
