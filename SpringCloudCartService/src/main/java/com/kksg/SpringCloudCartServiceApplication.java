package com.kksg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCartServiceApplication.class, args);
	}

}
