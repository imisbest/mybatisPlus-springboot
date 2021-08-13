package com.csw.mybatisSpringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.csw.mybatisSpringboot.mapper")
public class MybatisSpringbootApplication {

    public static void main(String[] args) {
        //mybatis插件启动
        System.out.println("jrebel测试aaa");
        SpringApplication.run(MybatisSpringbootApplication.class, args);
    }

}
