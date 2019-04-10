package com.dlnu.byname;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dlnu.byname.mapper")
public class ByNameApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ByNameApplication.class);
        SpringApplication.run(ByNameApplication.class,args);
        logger.info("............My ByName 启动成功.......");
    }

}

