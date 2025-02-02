package com.ratingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingmsApplication.class, args);
		System.out.println("Rating service started");
	}

}
