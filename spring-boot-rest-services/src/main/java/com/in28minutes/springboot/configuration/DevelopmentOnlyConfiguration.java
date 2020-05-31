package com.in28minutes.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;



@Profile("dev")
@Component
public class DevelopmentOnlyConfiguration {

	@Bean
	@Primary
	public String dummy() {
		return "something";
	}

	@Bean
	public String sampleBean() {
		return "Second Sample bean";
	}
}
