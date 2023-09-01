package com.bing.listener;


import com.alibaba.fastjson.JSON;
import com.bing.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

//@Configuration
public class KafkaConsumer {

//    @KafkaListener(topics = "register")
    public void consume(String message) {
        System.out.println("接收到消息：" + message);
        User user = JSON.parseObject(message, User.class);
        System.out.println("正在为 " + user.getName() + " 办理注册业务...");
        System.out.println("注册成功");
    }
}
