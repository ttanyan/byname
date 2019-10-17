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


package com.dlnu.byname.property;

/**
 * @author TanLianWang
 * @version 1.0
 * @ProjectName byname
 * @Description
 * @Date 2019/10/17 11:55
 */
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
 * 2018年3月13日    zhangduanfeng         Create the class
 * http://www.jimilab.com/
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @FileName ConfigProperties.java
 * @Description:
 *
 * @Date 2018年3月13日 下午5:36:10
 * @author zhangduanfeng
 * @version 1.0
 */
@Component
@EnableConfigurationProperties(ConfigProperties.SendDictate.class)
class ConfigProperties {

    @Value("${projectName:}")
    private String projectName;

    @Value("${sim.url:}")
    private String simUrl;

    @Value("${openapi.accesstoken:}")
    private String apiAccessToken;

    @Value("${language:zh}")
    private String language;

    @Value("${jpushAppKey:}")
    private String jpushAppKey;

    @Value("${jpushSecret:}")
    private String jpushSecret;

    @Value("${queryEquipmentNum:200}")
    private String queryEquipmentNum;



    public String getProjectName() {
        return projectName;
    }

    public String getSimUrl() {
        return simUrl;
    }

    public String getApiAccessToken() {
        return apiAccessToken;
    }

    public String getLanguage() {
        return language;
    }



    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setSimUrl(String simUrl) {
        this.simUrl = simUrl;
    }

    public void setApiAccessToken(String apiAccessToken) {
        this.apiAccessToken = apiAccessToken;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    public String getJpushAppKey() {
        return jpushAppKey;
    }

    public void setJpushAppKey(String jpushAppKey) {
        this.jpushAppKey = jpushAppKey;
    }

    public String getJpushSecret() {
        return jpushSecret;
    }

    public void setJpushSecret(String jpushSecret) {
        this.jpushSecret = jpushSecret;
    }

    public String getQueryEquipmentNum() {
        return queryEquipmentNum;
    }

    public void setQueryEquipmentNum(String queryEquipmentNum) {
        this.queryEquipmentNum = queryEquipmentNum;
    }



    @ConfigurationProperties(prefix = "tracker.sendDictate")
    public static class SendDictate {
        private String url;
        private int port;

        public String getUrl() {
            return url;
        }

        public int getPort() {
            return port;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setPort(int port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return String.format("SendDictate [url=%s, port=%s]", url, port);
        }

    }
}

