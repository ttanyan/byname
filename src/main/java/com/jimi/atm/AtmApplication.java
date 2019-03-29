package com.jimi.atm;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jimi.atm.mapper")
public class AtmApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(AtmApplication.class);
        SpringApplication.run(AtmApplication.class,args);
        logger.info("............JIMI ATM WEB 启动成功.......");
    }

}

