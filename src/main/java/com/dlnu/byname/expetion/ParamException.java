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
 * 2020-05-12 13:03                  TanLianWang          Create the class
 * http://www.chinautech.com/
 */

package com.dlnu.byname.expetion;

/**
 * 
 * @author TanLianWang 
 * @version 1.0 
 * @date 2020/5/12 13:04
 */
public class ParamException extends Exception{

    public ParamException(){
        super();
    }

    /**
     * 自定义消息
     * @param message
     */
    public ParamException(String message){
        super(message);
    }

    /**
     * 用指定message和原因构造一个新的异常
     * @param message
     * @param cause
     */
    public ParamException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * 用指定原因构造新的异常
     * @param cause
     */
    public ParamException(Throwable cause) {
        super(cause);
    }
}
