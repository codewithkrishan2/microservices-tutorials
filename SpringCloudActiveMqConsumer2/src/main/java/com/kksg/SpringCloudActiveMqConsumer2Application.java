package com.kksg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringCloudActiveMqConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudActiveMqConsumer2Application.class, args);
	}

}
