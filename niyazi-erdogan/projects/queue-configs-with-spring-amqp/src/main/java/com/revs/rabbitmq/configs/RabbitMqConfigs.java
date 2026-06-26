package com.revs.rabbitmq.configs;

import com.revs.rabbitmq.listener.SimpleMessageListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfigs {

    private static final String MY_QUEUE = "MyQueue";
    private static final String MY_QUEUE2 = "MyQueue2";

    @Bean
    Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    @Bean
    Queue myQueue2() {
        return QueueBuilder.durable(MY_QUEUE2)
                .exclusive()
                .autoDelete()
                .build();
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.directExchange("MyExchange")
                .durable(true)
                .internal()
                .autoDelete()
                .build();
    }

    @Bean
    Binding myBinding() {
        return BindingBuilder.bind(myQueue()).to(myExchange()).with("my.routing.key").noargs();
    }

}
