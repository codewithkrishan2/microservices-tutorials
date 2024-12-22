package com.kksg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kksg.client.entity.Cart;

@FeignClient("CART-SERV")
public interface PaymentCartService {

	@GetMapping("/cart/get")
	public ResponseEntity<String> getCart();
	
	@GetMapping("/cart/getbyid/{id}")
	public ResponseEntity<Cart> getCartbyId(@PathVariable("id") int id);
}
