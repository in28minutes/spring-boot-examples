package com.in28minutes.springboot.tutorial.basics.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.out;

@SpringBootApplication
public class SpringBootTutorialBasicsApplication {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(SpringBootTutorialBasicsApplication.class, args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
           out.println(name);
        }
    }
}
