package com.in28minutes.springboot.rest.example;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요, Gwangjin!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "안녕히 계세요, Gwangjin!";
    }
}
