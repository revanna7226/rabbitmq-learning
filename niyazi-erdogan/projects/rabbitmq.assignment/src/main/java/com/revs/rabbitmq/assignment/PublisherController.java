package com.revs.rabbitmq.assignment;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend("assignment.exchange", "assignment.routing.key", message);
    }

}
