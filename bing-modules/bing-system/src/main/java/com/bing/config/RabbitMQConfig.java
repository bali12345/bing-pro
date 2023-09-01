package com.bing.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
@Slf4j
public class RabbitMQConfig {

	/**
	 * Producer com.bing.config
	 *
	 * Let the producer produce json message by default.
	 * @return
	 */
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setChannelTransacted(true);

		MessageConverter customJsonMessageConverter = new SimpleMessageConverter() {
			@Override
			protected Message createMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
				String stringMessage = JSONUtil.toJsonStr(object);
				log.info("消息转换成JSON后:{}",stringMessage);
				return super.createMessage(stringMessage, messageProperties);
			}
		};
		template.setMessageConverter(customJsonMessageConverter);
		return template;
	}
}
