package com.kksg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kksg.service.db.MessageStore;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerServiceImpl {

	@Autowired
	private MessageStore messageStore;
	
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "abcd")
	public void consumeMessage(String message) {
		messageStore.add(message);
		log.info("Consuming message at consumer service -> {}", message);
	}
	
}
