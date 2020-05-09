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
 * 2020/3/11    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description  输入字符串自动去重并算个数
 * @Date 2020/3/11 8:20 下午
 */
import java.util.*;
public class SSToS {
        public static int charNum(){
            Scanner in = new Scanner(System.in);
            String inString = in.nextLine();
           HashSet<String> hashSet = new HashSet<>();
            for(int i=0; i<inString.length(); i++) {
                String s =  String.valueOf(inString.charAt(i));
                hashSet.add(s);
            }
            return hashSet.size();
        }
        public static void main(String[] args){
            System.out.println(charNum());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add("\""+i+"\"");
            }
            System.out.println(list);
        }
}
