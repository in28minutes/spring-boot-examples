package com.in28minutes.springboot.rest.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.in28minutes.springboot.rest.example.student.Student;

public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요, Gwangjin!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "안녕히 계세요, Gwangjin!";
    }

    @GetMapping("/breakTime")
    public String breakTime() {
        return "안녕히 계세요, Gwangjin!";
    }

    @PostMapping("/email")
    public String getEmail(@RequestBody Student user) {
        System.out.println(user.getName());
        System.out.println(user.getPassportNumber());
        return user.getName().toLowerCase(); // user가 null일 가능성 있음!
    }
}
