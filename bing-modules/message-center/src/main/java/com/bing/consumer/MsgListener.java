package com.bing.consumer;


import cn.hutool.system.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;


@Slf4j
@Component
public class MsgListener {

    @RabbitListener(queues = "user.register.binding", containerFactory = "rabbitListenerContainerFactory")
    public void goodsSyncBlw(String msg) {
        log.info("接收到的消息:{}",msg);
    }
}
