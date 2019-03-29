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
 * 2018年12月17日    TanLianWang         Create the class
 * http://www.jimilab.com/
*/

package com.jimi.atm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @FileName ProduceNumber.java
 * @Description: 
 *
 * @Date 2018年12月17日 上午2:34:08
 * @author TanLianWang
 * @version 1.0
 */
public class ProduceNumber {
        /**
         * 随机产生6不重复的银行卡账号
         */

        List<String> list = new ArrayList<String>();
        public  String produceNumber() {
            Random r = new Random();
            String str = "";
            /**
             * 循环4次
             */
            for (int i = 0; i < 6; i++) {
                Integer x = r.nextInt(10);
                str += x.toString();
            }
            /**
             * 存在则在重新生成一次
             */
            if (list.contains(str)) {
                list.remove(str);
                this.produceNumber();
            }
            list.add(str);
            return str;
        }

}
