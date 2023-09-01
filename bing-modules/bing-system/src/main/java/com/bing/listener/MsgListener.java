package com.bing.listener;


import com.bing.constants.RabbitMQMallConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class MsgListener {


//    @RabbitListener(queues = RabbitMQMallConstants.USER_REGISTER_BINDING_QUEUE)
    public void goodsSyncBlw(String msg) {
        log.info("接收到的消息:{}",msg);
    }
}
