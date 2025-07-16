package com.in28minutes.springboot.rest.example;

import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/email")
    public String getEmail(Student user) {
        return user.getName().toLowerCase(); // user가 null일 가능성 있음!
    }    
}
