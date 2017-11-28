package com.in28minutes.springboot.tutorial.basics.example.aop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business1;
import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Business1 business1;

	@Autowired
	private Business2 business2;

	@Test
	public void invokeAOPStuff() {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}
}