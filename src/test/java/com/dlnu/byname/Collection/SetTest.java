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
 * 2020/5/10    anyant         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.Collection;

import java.util.HashSet;

/**
 * @author anyant
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2020/5/10 11:02 上午
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.forEach(p->{
            System.out.println(p);
        });

    }
}
