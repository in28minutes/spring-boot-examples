package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping("/welcome")
    public String loginMessage() {
        return "welcome";
    }
}