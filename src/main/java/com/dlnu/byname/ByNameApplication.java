package com.dlnu.byname;

import com.dlnu.byname.shiro.ShiroConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 启动类
 *
 * @param
 * @author TanLianWang
 * @return null
 * @date 2019/5/13 22:00
 */
@SpringBootApplication
//@EnableFeignClients
@MapperScan(basePackages = "com.dlnu.byname.mapper")
public class ByNameApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ByNameApplication.class);
        SpringApplication.run(ByNameApplication.class, args);
        logger.info("===============My ByName 启动成功==============");
    }


}

