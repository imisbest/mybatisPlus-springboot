package com.csw.mybatisSpringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.csw.mybatisSpringboot.mapper")
public class MybatisSpringbootApplication {
    private static final Logger logger = LoggerFactory.getLogger(MybatisSpringbootApplication.class);

    public static void main(String[] args) {
        //mybatis插件启动
        logger.info("" + "jrebel测试aaa");
        SpringApplication.run(MybatisSpringbootApplication.class, args);
    }

}
