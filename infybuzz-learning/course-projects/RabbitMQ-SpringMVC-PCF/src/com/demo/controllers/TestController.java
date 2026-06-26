package com.demo.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
	public String testAPI(@PathVariable("name") String name){
		Person p = new Person(1L, name);
		rabbitTemplate.convertAndSend("Mobile", p);
		return "Success";
	}
}
