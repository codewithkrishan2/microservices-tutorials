package com.kksg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kksg.client.PaymentCartService;
import com.kksg.client.entity.Cart;

@RestController
@RequestMapping("/payment")
@RefreshScope
public class PaymentController {

	@Autowired
	private PaymentCartService service;
	
	@Value("${my.app.title}")
	private String myapp;
	
	//get cart service info
	@GetMapping("/get")
	public ResponseEntity<String> getPayment() {
		
		String response = service.getCart().getBody();
		return response != null ? ResponseEntity.ok("Order placed with Cart details:"+response + "title is :"+myapp) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<String> getPaymentbyId(@PathVariable("id") int id) {
		
		Cart response = service.getCartbyId(id).getBody();
		return response != null ? ResponseEntity.ok("Order placed with Cart details:"+response) : ResponseEntity.notFound().build();
	}
}
