package com.qa;

import org.springframework.amqp.core.Binding;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class Application {

    static final String topicExchangeName = "spring-boot-exchange";

	private static final String queueGet = "get";
	
	private static final String queuePost = "post";

    @Bean
    Queue queueGetRequest() {
        return new Queue(queueGet, false);
    }
    
    @Bean
    Queue queuePostRequest() {
        return new Queue(queuePost, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding bindingGet(Queue queueGetRequest, TopicExchange exchange) {
        return BindingBuilder.bind(queueGetRequest).to(exchange).with("get");
    }
    
    @Bean
    Binding bindingPost(Queue queuePostRequest, TopicExchange exchange) {
    	return BindingBuilder.bind(queuePostRequest).to(exchange).with("post");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}
