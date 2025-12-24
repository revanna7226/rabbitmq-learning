package com.revs.rabbitmq.utils;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @RabbitListener(queues = "Mobile")
    public void listenToMobile(String message) {
        System.out.println("Mobile -> Received Message: " + message);
    }

    @RabbitListener(queues = "AC")
    public void listenToAC(String message) {
        System.out.println("AC -> Received Message: " + message);
    }

    @RabbitListener(queues = "TV")
    public void listenToTV(String message) {
        System.out.println("TV -> Received Message: " + message);
    }
    @RabbitListener(queues = "Queue1")
    public void listenQueue(String message) {
        System.out.println("Queue1 -> Received Message: " + message);
    }
}
