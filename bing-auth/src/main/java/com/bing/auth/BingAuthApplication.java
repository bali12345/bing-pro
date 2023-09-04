package com.bing.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableRyFeignClients
//@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BingAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(BingAuthApplication.class, args);
    }
}
