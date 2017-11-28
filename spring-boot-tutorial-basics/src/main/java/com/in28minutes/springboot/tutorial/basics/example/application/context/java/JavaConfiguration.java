package com.in28minutes.springboot.tutorial.basics.example.application.context.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
	
	@Bean
	public String someDummyBean1() {
		return "someDummyBean1";
	}
	
	@Bean
	public String someDummyBean2() {
		return "someDummyBean2";
	}

}
