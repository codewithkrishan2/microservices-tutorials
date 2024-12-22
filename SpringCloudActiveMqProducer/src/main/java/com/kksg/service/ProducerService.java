package com.kksg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate jt;
	
	
	@Value("${my.app.desti-name}")
	private String destinationname;
	
	
	public void produceMessage(String message) {
		jt.send(destinationname, session -> session.createTextMessage(message));
		System.out.println("Message sent from producer: "+ message );
	}
}
