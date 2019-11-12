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
 * 2019/10/17    TanLianWang        Create the class
 * http://www.jimilab.com/
 */


package com.dlnu.byname.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName ConfigProperties
 * Description
 *  配置加载类
 * Date 2019/11/12 10:34
 * author TanLianWang
 */
@Component
@EnableConfigurationProperties(ConfigProperties.MqProperties.class)
public class ConfigProperties {
    @Value("${jimi.sendPhone.token:}")
    private String sendPhoneToken;

    @Resource
    MqProperties mqProperties;

    @Value("${fkc.DeviceInfo}")
    private String fkcDeviceInfo;


    @Value("${fkc.token}")
    private String fkcToken;

    public String getSendPhoneToken() {
        return sendPhoneToken;
    }

    public void setSendPhoneToken(String sendPhoneToken) {
        this.sendPhoneToken = sendPhoneToken;
    }

    public MqProperties getMqProperties() {
        return mqProperties;
    }

    public void setMqProperties(MqProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    public String getFkcDeviceInfo() {
        return fkcDeviceInfo;
    }

    public void setFkcDeviceInfo(String fkcDeviceInfo) {
        this.fkcDeviceInfo = fkcDeviceInfo;
    }


    public String getFkcToken() {
        return fkcToken;
    }

    public void setFkcToken(String fkcToken) {
        this.fkcToken = fkcToken;
    }

    @Override
    public String toString() {
        return "ConfigProperties{" +
                "sendPhoneToken='" + sendPhoneToken + '\'' +
                ", mqProperties=" + mqProperties +
                ", fkcDeviceInfo='" + fkcDeviceInfo + '\'' +
                ", fkcToken='" + fkcToken + '\'' +
                '}';
    }

    @ConfigurationProperties(prefix = "MQ")
    public static class MqProperties {
        private String url;
        private String username;
        private String password;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "MqProperties{" +
                    "url='" + url + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }


}
