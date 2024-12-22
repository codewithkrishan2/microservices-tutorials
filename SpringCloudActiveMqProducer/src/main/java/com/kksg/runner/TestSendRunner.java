package com.kksg.runner;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kksg.service.ProducerService;

@Component
public class TestSendRunner {
//implements CommandLineRunner {

	@Autowired
	private ProducerService producerService;
	
//	@Override
//	public void run(String... args) throws Exception {
	
	@Scheduled(cron = "0/10 * * * * *")
	public void sendMessage() throws Exception {
		System.out.println("Test Send Runner is running...");
		producerService.produceMessage("Hello from TestSendRunner "+ LocalDateTime.now());
	}

}
