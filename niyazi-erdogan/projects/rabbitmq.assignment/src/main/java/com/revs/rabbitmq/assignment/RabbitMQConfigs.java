package com.revs.rabbitmq.assignment;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigs {

    private final static String EXCHANGE_NAME = "assignment.exchange";
    private final static String QUEUE_NAME = "assignment.queue";

    @Bean
    Queue assignmentQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    Exchange assignmentExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).build();
    }

    @Bean
    Binding assignmentBinding() {
        return BindingBuilder.bind(assignmentQueue()).to(assignmentExchange()).with("assignment.routing.key").noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        return factory;
    }

    @Bean
    MessageListenerContainer assignmentMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(new SimpleMessageListener());
        return container;
    }

}
