package com.qa;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
/*
	static final String queueName = "spring-boot";
	
	@RabbitListener(queues = queueName)
	*/
	@RabbitListener(queues="get")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + "from queue 1" + ">");
    }
	
	@RabbitListener(queues="post")
    public void receiveMessage2(String message) {
        System.out.println("Received <" + message + "from queue 2" + ">");
    }
}
