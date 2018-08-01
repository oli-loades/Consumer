package com.qa;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

	public void receiveMessage2(String message) {
		System.out.println("Received <" + message + ">");
	}
}
