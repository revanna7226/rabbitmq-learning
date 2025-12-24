package com.demo.controllers;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@EnableRabbit
public class RabbitMQConsumer {

	@RabbitListener(queues = "Mobile")
	public void getMessage(Person p){
		System.out.println(p.getName());
	}
}
