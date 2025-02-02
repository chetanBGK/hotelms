package com.hotelms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient

public class HotelmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmsApplication.class, args);
		System.out.println("Hotelms Application Started");
	}

}
