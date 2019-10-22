package com.in28minutes.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ProductionOnlyConfiguration {
	@Bean
	@Primary
	public String dummy() {
		return "something";
	}

	@Bean
	public String anotherBean(){
		return "Production bean";
	}
}
