/*
 * COPYRIGHT. AnyanT tanlianwang@qq.com
 * ALL RIGHTS RESERVED
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording,
 * or otherwise, without the prior written permission of AnyanT.
 * Amendment History:
 * Amendment History:
 *
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2021/1/18                 anyant           Create the class
 * https://blog.csdn.net/tingfengqianqu
 */


package com.dlnu.byname.consumerkafka.services.impl;

import com.dlnu.byname.consumerkafka.services.MessageProcessorService;
import org.springframework.stereotype.Service;

/**
 * @author anyant
 * @version 1.0
 * @Description
 * @Date 2021/1/18 22:44
 */
@Service
public class MessageProcessorServiceImpl implements MessageProcessorService {

    @Override
    public String beforeMessageProcessor(String value) {
        return value+"hello";
    }

    @Override
    public String afterMessageProcessor(String value) {
        return null;
    }
}
