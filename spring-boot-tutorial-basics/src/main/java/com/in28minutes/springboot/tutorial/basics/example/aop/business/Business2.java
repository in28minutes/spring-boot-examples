package com.in28minutes.springboot.tutorial.basics.example.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.example.aop.data.Dao2;

@Service
public class Business2 {
	
	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething(){
		//Business Logic
		return dao2.retrieveSomething();
	}
}