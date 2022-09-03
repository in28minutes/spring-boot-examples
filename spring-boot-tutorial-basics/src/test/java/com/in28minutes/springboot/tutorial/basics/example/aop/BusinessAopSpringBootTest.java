package com.in28minutes.springboot.tutorial.basics.example.aop;

import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business1;
import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BusinessAopSpringBootTest {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Business1 business1;

    @Autowired
    private Business2 business2;

    @Test
    public void invokeAOPStuff() {
        LOGGER.info(business1.calculateSomething());

        LOGGER.info(business2.calculateSomething());
    }
}