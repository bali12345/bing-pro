package com.bing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bing.mapper")
public class BingSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(BingSysApplication.class, args);
    }
}