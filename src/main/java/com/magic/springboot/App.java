package com.magic.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-05-31---下午9:14
 */
@SpringBootApplication
public class App {
    //启动时，必须通过maven运行spring-boot:run才能正常访问，直接运行此类，报404错误
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
