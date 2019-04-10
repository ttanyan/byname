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
 * 2018/12/26    Tanlianwang         Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname;

import com.dlnu.byname.domain.entity.ClientDO;
import com.dlnu.byname.mapper.ClientMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 13:42
 */

public class ClientTest extends  BaseTest{
    @Resource
    private ClientMapper clientMapper;


       @Test
    public void ListAllClient(){
        List<ClientDO> list = clientMapper.ListAllClient();
        for (int i = 0; i < list.size(); i++) {
            logger.info(list.get(i).getClientName());
        }

    }

    @Test
    public void getClient(){
            ClientDO clientDO = clientMapper.get("500234199607024994","tan1230");
            System.out.println(clientDO);
    }

    @Test
    public void deleteClient(){
           clientMapper.deleteClient("123456");
    }
    @Test
    public void updateClient(){

           clientMapper.updateClient("500234199607024994","李龙","tan1230");
    }

    @Test
    public  void selectMoney(){
         String i =  clientMapper.selectMoney("500234199607024994");
        System.out.println(i);
    }



}
