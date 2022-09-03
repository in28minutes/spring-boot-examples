package com.in28minutes.springboot.tutorial.basics.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "execution(* com.in28minutes.springboot.tutorial.basics.example.aop.business.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("{} returned with value {}", joinPoint, result);
    }

    @After(value = "execution(* com.in28minutes.springboot.tutorial.basics.example.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.info("after execution of {}", joinPoint);
    }
}