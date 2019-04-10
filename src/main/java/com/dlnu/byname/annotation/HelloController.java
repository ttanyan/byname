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
 * 2018年12月19日    TanLianWang         Create the class
 * http://www.jimilab.com/
*/

package com.dlnu.byname.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName HelloController.java
 * @Description: 
 * demo1
 * @Date 2018年12月19日 上午11:43:37
 * @author TanLianWang
 * @version 1.0
 */
@RestController
public class HelloController {
    
    @RequestMapping("/add1")  
    public String qwe1(String deviceId ) {
        return "执行成功";
    }
    
    @RequestMapping("/add2")  
    public String addData2(String deviceId,String x,String y) {
        return "success";
    }
    
    @RequestMapping("/add3")  
    public String addData3(String deviceId) {
        return "success";
    }
    
}