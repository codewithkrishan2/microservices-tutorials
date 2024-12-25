package com.kksg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaServiceExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaServiceExApplication.class, args);
	}

	/**
	 * Execution order:
	 * 1. run Zookeeper
	 * 2. run Kafka server
	 * 3. run the application
	 * 4. send a message to the topic
	 * 5. check the logs
	 * 
	 * */
}
