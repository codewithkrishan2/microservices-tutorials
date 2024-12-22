package com.kksg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPaymentServiceApplication.class, args);
	}

}
