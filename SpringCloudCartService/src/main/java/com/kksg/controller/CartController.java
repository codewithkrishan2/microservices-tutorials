package com.kksg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kksg.entity.Cart;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController {

	@Value("${server.port}")
	private String port;

	@Value("${my.app.title}")
	private String title;
	
	@GetMapping("/get")
	public ResponseEntity<String> getCart() {
		return ResponseEntity.ok("Cart Serive is up and running" + port + " title is from github is : " + title);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Cart> getCartbyId(@PathVariable("id") int id) {
		Cart cart = new Cart();
		cart.setCartaId(id);
		cart.setCartName("Cart"+id);
		cart.setCartCost(1000.0);
		return ResponseEntity.ok(cart);
	}
}
