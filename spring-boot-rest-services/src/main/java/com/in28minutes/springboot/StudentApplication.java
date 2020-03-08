package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

//@PropertySource(value="classpath:application-dev.properties")
@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				StudentApplication.class, args);
		//System.out.println(ctx);
	}

}