package com.kksg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kksg.service.ProducerService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProducerServiceImpl implements ProducerService {

//	Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

	@Autowired
	private KafkaTemplate<String, String> template;	
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	@Override
	public void sendMessage(String message) {
		log.info("Producing message at producer service -> {}", message);
		template.send(topicName, message);
		//logger.info(String.format("Produced message -> %s", message));
	}
}
