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


package com.dlnu.byname.controller;

import com.dlnu.byname.domain.entity.ClientDO;
import com.dlnu.byname.services.ClientService;
import com.dlnu.byname.util.MD5;
import com.dlnu.byname.util.ProduceNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Tanlianwang
 * @version 1.0
 * @date 2018/12/26 20:51
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Resource
    ClientService clientService;

    /**
     * 登录跳转
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "clientLogin";
    }

    /**
     * 注册跳转
     * @param request
     * @return
     */
    @RequestMapping("/skp")
    public String skp(HttpServletRequest request){
        /**
         * 随机产生6位银行卡账号
         */
        ProduceNumber produceNumber = new ProduceNumber();
        String accountNumber = produceNumber.produceNumber();
        request.getSession().setAttribute("clientAccount",accountNumber);
        return  "clientRegist";
    }

    /**
     * 余额查询跳转
     * @return
     */
    @RequestMapping("skpSelectMoney")
    public String skpSelectMoney(){
        return "selectMoney";
    }

    /**
     * 存钱操作跳转
     * @return
     */
    @RequestMapping("/skpAddMoney")
    public String skpAddMoney(){
        return "addMoney";
    }
    /**
     * 取钱跳转
     * @return
     */
    @RequestMapping("/skpGetMoney")
    public String skpGetMoney(){
        return "getMoney";
    }

    /**
     * 跳转主页
     * @param clientIdNumber
     * @param passWord
     * @param request
     * @return
     */
    @RequestMapping("/home")
    public String home(@Param("clientIdNumber") String clientIdNumber,@Param("passWord") String passWord ,
                       HttpServletRequest request){
                  String pswMD = MD5.getMD5String(passWord);
                  ClientDO clientDO = clientService.loginClient(clientIdNumber,pswMD);
                  request.getSession().setAttribute("clientIdNumber",clientIdNumber);
                  if(clientDO == null){
                      request.getSession().setAttribute("loginMessage", "用户名或密码错误!");
                      return "clientLogin";
                  }else{
                        //必须确保clientDO不为空后才能进行get or set 或者将会抛出空指针异常
                      request.getSession().setAttribute("clientName", clientDO.getClientName());
                      return "clientIndex";
                  }
    }

    /**
     * 用户注册
     * @param clientIdNumber
     * @param clientName
     * @param clientPhone
     * @param clientAccount
     * @param clientPassword
     * @param request
     * @return
     */
    @RequestMapping("/regist")
    public String regist(@Param("clientIdNumber") String clientIdNumber,@Param("clientName") String clientName,
                         @Param("clientPhone") String clientPhone,@Param("clientAccount") String clientAccount,
                         @Param("clientPassword") String clientPassword,HttpServletRequest request){
            String pswMD5 = MD5.getMD5String(clientPassword);
            boolean a = false;
                    a = clientService.regist(clientIdNumber,clientName,clientPhone,clientAccount,pswMD5);
            if(a){
                request.getSession().setAttribute("loginMessage", "注册成功，请登陆!");
                return "clientLogin";

            }else{
                request.getSession().setAttribute("registMessage", "注册失败，请重新输入！");
                return "clientRegist";
            }
    }

    /**
     * 余额查询
     * @param clientIdNumber
     * @param request
     * @return
     */
    @RequestMapping("/selectMoney")
    public String selectMoney(@Param("clientIdNumber") String clientIdNumber,HttpServletRequest request){
            String money = clientService.selectMoney(clientIdNumber);
            request.getSession().setAttribute("selectMoney",money);
        return "selectMoney";
    }

    /**
     * c存钱操作
     * @param clientMoney
     * @param clientIdNumber
     * @param request
     * @return
     */
    @RequestMapping("/addMoney")
    public String addMoney(@Param("clientMoney") String clientMoney,@Param("clientIdNumber") String clientIdNumber,HttpServletRequest request){
        boolean a = false;
        int addMoney = Integer.valueOf(clientMoney);
        int dooMoney = Integer.valueOf(clientService.selectMoney(clientIdNumber));
        String sunMoney =  String.valueOf((addMoney + dooMoney));

               a = clientService.addMoney(sunMoney,clientIdNumber);
        if(a){
            request.getSession().setAttribute("addMoneyMessage", "成功");
            return "addMoney";

        }else{
            request.getSession().setAttribute("addMoneyMessage", "失败");
            return "addMoney";
        }
    }

    /**
     * 取钱操作
     * @param clientMoney
     * @param clientIdNumber
     * @param request
     * @return
     */
    @RequestMapping("/getMoney")
    public String getMoney(@Param("clientMoney") String clientMoney,@Param("clientIdNumber") String clientIdNumber,HttpServletRequest request){
        boolean a = false;
        int addMoney = Integer.valueOf(clientMoney);
        int dooMoney = Integer.valueOf(clientService.selectMoney(clientIdNumber));
        if(addMoney<=dooMoney){
            String sunMoney =  String.valueOf((dooMoney - addMoney ));
             clientService.addMoney(sunMoney,clientIdNumber);
            request.getSession().setAttribute("getMoneyMessage", "取款成功");
            return "getMoney";
        } else{
            request.getSession().setAttribute("getMoneyMessage", "余额不足");
            return "getMoney";
        }
    }


    /**
     * 安全退出
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    public String home(HttpServletRequest request) {
        /**
         * 清空session
         */
        request.getSession().invalidate();
        return "clientLogin";
    }




}
