/*
 * COPYRIGHT. ChongQing UTECH Technology Co., Ltd. 2020.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of ChongQing UTECH Network Technology Co., Ltd.
 *
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2020-05-09 9:40                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.Collection;

import java.util.ArrayList;
import java.util.List;

public class listDemo {
    public static void main(String[] args) {
      List<Integer>  list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.remove(1); //将后面的所有元素移除了 抛出下标越界异常
//            return;
        }

    }
}
