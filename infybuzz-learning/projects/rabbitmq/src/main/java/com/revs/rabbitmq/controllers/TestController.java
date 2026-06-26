package com.revs.rabbitmq.controllers;

import com.revs.rabbitmq.utils.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    final private RabbitMQProducer rabbitMQProducer;

    @PostMapping("/queue")
    public String toQueue(@RequestBody PublishMessage publishMessage) {
        rabbitMQProducer.sendMessage(publishMessage.getQueueName(), publishMessage.getMessage());
        return "Test endpoint is working!";
    }

    @PostMapping("/exchange")
    public String toExchange(@RequestBody PublishMessage publishMessage) {
        String message = publishMessage.getMessage();
        String exchange = publishMessage.getExchange();
        String routingKey = publishMessage.getRoutingKey();

        if(!publishMessage.getHeaders().isEmpty()) {
            MessageProperties properties = new MessageProperties();
            Map<String, Object> headers = publishMessage.getHeaders();
            headers.forEach(properties::setHeader);

            Message msg = new Message(
                message.getBytes(StandardCharsets.UTF_8),
                properties
            );

            rabbitMQProducer.sendMessage(
                exchange,
                "", // routing key ignored
                msg);
        } else {
            rabbitMQProducer.sendMessage(exchange, routingKey, message);
        }
        return "Test endpoint is working!";
    }

}
