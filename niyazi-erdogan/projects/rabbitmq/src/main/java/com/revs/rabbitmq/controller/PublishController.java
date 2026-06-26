package com.revs.rabbitmq.controller;

import com.revs.rabbitmq.RabbitmqApplication;
import com.revs.rabbitmq.model.SimpleMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    protected static final Logger logger = LogManager.getLogger(PublishController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publishMessageString")
    public String publishSimpleMessage(String message) {
        rabbitTemplate.convertAndSend("RevsTestExchange", "testRouting", message);
        logger.info("Message published to RabbitMQ");
        return "Message published";
    }

    @PostMapping("/publishMessageObject")
    public String publishObjectMessage(SimpleMessage message) {
        rabbitTemplate.convertAndSend("RevsTestExchange", "testRouting", message);
        logger.info("Message published to RabbitMQ");
        return "Message published";
    }

}