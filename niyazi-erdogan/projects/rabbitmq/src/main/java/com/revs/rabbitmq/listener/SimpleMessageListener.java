package com.revs.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageListener implements MessageListener {

    @RabbitListener(queues = "RevsTestQueue")
    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        System.out.println("Received message: " + messageBody);
    }
}
