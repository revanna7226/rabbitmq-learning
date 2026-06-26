package com.revs.rabbitmq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("RabbitMQ Application Started...");
	}
}
