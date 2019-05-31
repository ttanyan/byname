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
 * 2019/5/13      TanLianWang       Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.constant;

/**
 * @author TanLianWang
 * @version 1.0
 * @Description
 * @Date 2019/5/13 17:44
 */
public class JsonResult<T> {
    /**
     * 数据
     */
    private T data;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 响应结果
     */
    private String msg;
    /**
     * 返回总数
     */
    private Integer count;

    /**
     * 若没有数据返回，默认状态码为0，总数为0。提示信息为“操作成功！”
     */
    public JsonResult() {
        this.code = 0;
        this.msg = "操作成功！";
        this.count = 0;
    }

    /**
     * 若没有数据返回，状态码为500，人为指定提示信息
     * @param msg 响应结果
     */
    public JsonResult( String msg) {
        this.code = 500;
        this.msg = msg;
        this.count = 0;
    }

    /**
     * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”,总数为0
     * @param data 数据
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
        this.count = 0;
    }

    /**
     * 有数据返回，状态码为0，默认提示信息为“操作成功！”,人为指定总数
     * @param data 数据
     * @param count 总数
     */
    public JsonResult(T data, Integer count) {
        this.data = data;
        this.code = 0;
        this.msg = "操作成功！";
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
