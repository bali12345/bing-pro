package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.constants.RabbitMQMallConstants;
import com.bing.entity.User;
import com.bing.entity.UserInfo;
import com.bing.service.UserInfoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class TestController {

    @Autowired
    private UserInfoService userInfoService;

    @Resource
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    KafkaTemplate<String, String> kafka;

    @GetMapping("all")
    public String selectUserAll(){
        List<UserInfo> list = userInfoService.list();

        return list.toString();
    }

    @GetMapping("send")
    public String send(){
        UserInfo userInfo = new UserInfo();
        String msg = "测试消息";
        userInfo.setUserName("张三");
        userInfo.setId("13131313232");
        rabbitTemplate.convertAndSend(RabbitMQMallConstants.BING_EXCHANGE,RabbitMQMallConstants.ROUTING_USER_CHANGE,userInfo);

        return "success";
    }

//    @PostMapping("register")
//    public String register(@RequestBody User user) {
//        String message = JSON.toJSONString(user);
//        System.out.println("接收到用户信息：" + message);
//        kafka.send("register", message);
//
//        return "OK";
//    }


}
