package com.kksg.congif;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("cartRoutingId", r -> r.path("/cart/**").uri("lb://CART-SERV"))
//				.route("cartRoutingId", r -> r.path("/cart/**").uri("http://localhost:8081"))
				.route("paymentRoutingId", r -> r.path("/payment/**").uri("lb://PAYMENT-SERV"))
//				.route("paymentRoutingId", r -> r.path("/payment/**").uri("http://localhost:9091"))
				.build();
	}

}
