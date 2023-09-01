package com.bing.config;


import com.bing.constants.RabbitMQMallConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(EnableRabbit.class)
@Configuration
public class RabbitMQDefinitionConfig {

    @Bean
    public TopicExchange bingExchange() {
        return new TopicExchange(RabbitMQMallConstants.BING_EXCHANGE);
    }

    @Bean
    public Queue bingSyncQueue() {
        return new Queue(RabbitMQMallConstants.USER_REGISTER_BINDING_QUEUE);
    }


    @Bean
    Binding goodsInfoChangeBinding() {
        return BindingBuilder.bind(bingSyncQueue()).to(bingExchange()).with(RabbitMQMallConstants.ROUTING_USER_CHANGE);
    }
}
