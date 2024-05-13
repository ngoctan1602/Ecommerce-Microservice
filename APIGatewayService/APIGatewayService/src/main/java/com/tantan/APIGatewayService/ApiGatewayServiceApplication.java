package com.tantan.APIGatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("AddressServices", r -> r.path("/address/**").uri("lb://AddressServices"))
				.route("ProductService", r -> r.path("/product/**").uri("lb://ProductService"))
				.route("TypeBusService", r -> r.path("/typebus/**").uri("lb://TypeBusService"))
				.route("InventoryService", r -> r.path("/inventory/**").uri("lb://InventoryService"))
				.build();
	}
}
