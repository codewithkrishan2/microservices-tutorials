package com.kksg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentCartService {

	@Autowired
	private LoadBalancerClient client;
	
	public String getCartResponse() {
		ServiceInstance si = client.choose("SpringCloudCartService");
		
		String url = si.getUri()+"/cart/get";
		System.out.println("*******************************   "+url);
		
		RestTemplate rt = new RestTemplate();
		
		String result = rt.getForObject(url, String.class);
		
		System.out.println(result);
		
		return result;
	}
	
}
