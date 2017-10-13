package com.arkhotech.meetup.microservices.productos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration //defines this as a Spring Boot application
@EnableDiscoveryClient //this enables service registration and discovery. In this case, this process registers itself with the discovery-server service using its application name 
@SpringBootApplication
public class ProductosApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductosApplication.class, args);
		logger.info("*** EJECUTANDO MICROSERVICIO PRODUCTOS");
	}
}
