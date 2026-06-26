package com.revs.rabbitmq.assignment;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageListener implements MessageListener {
    /**
     * Delivers a single message.
     *
     * @param message the message.
     */
    @Override
    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        System.out.println("Received message: " + messageBody);
    }
}
