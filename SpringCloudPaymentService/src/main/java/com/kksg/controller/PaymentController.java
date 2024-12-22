package com.kksg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kksg.service.PaymentCartService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentCartService service;
	
	@GetMapping("/get")
	public String getPayment() {
		String response = service.getCartResponse();
		return "Payment details with Cart details: "+response;
	}
	
}
