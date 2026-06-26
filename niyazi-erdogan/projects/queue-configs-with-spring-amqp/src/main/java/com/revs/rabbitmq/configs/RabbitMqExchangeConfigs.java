package com.revs.rabbitmq.configs;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqExchangeConfigs {

    private static final String MY_EXCHANGE = "MyExchange";

    @Bean
    Exchange myExchange() {
        return new DirectExchange(MY_EXCHANGE);
    }

    @Bean
    Exchange anotherExchange() {
        return ExchangeBuilder.topicExchange("AnotherExchange")
                .durable(true)
                .internal()
                .autoDelete()
                .build();
    }

}
