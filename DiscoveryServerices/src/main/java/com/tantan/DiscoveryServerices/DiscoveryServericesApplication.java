package com.tantan.DiscoveryServerices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServericesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServericesApplication.class, args);
	}

}
