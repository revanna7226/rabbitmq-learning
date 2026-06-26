package com.revs.rabbitmq.configs;

import com.revs.rabbitmq.listener.SimpleMessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfigs {

    @Bean
    ConnectionFactory connectionFactory() {
        // Configure and return your ConnectionFactory here
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        return connectionFactory; // Replace with actual implementation
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        // Configure and return your MessageListenerContainer here
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("RoutedQueue");
        container.setMessageListener(new SimpleMessageListener());
        return container; // Replace with actual implementation
    }

}
