package com.in28minutes.springboot.microservice.eureka.naming.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMicroserviceEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceEurekaNamingServerApplication.class, args);
	}
}
