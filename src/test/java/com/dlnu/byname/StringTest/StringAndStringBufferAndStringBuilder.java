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
 * 2020/5/7    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.StringTest;

//import sun.util.resources.LocaleData;

import java.time.LocalDateTime;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/7 11:35 下午
 */
public class StringAndStringBufferAndStringBuilder {
    public static void main(String[] args) {
//StringBuffer与StringBuilder都很快  String很慢并且内存消耗很大
//        StringBuilder s = new StringBuilder("s");
//        String  s = "s";
        StringBuffer s = new StringBuffer("s");
        System.out.println(LocalDateTime.now());
        for (int i = 0; i <= 100000; i++) {
//            s = s+i;
             s = s.append(i);
             if(i == 100000){
                 System.out.println(s);
                 System.out.println(LocalDateTime.now());
             }
        }


    }
}
