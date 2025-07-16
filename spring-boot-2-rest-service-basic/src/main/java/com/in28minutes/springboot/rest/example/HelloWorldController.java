package com.in28minutes.springboot.rest.example;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldController {
    @GetMapping("/gwangjin")
    public String helloGwangjin() {
        return "안녕하세요, Gwangjin!";
    }
}
