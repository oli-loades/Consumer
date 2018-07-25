package com.qa;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
/*
	static final String queueName = "spring-boot";
	
	@RabbitListener(queues = queueName)
	*/
	
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
