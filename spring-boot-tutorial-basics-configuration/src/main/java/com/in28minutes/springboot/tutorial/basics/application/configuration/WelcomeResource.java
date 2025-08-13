package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeResource {

    @Value("${welcome.message}")
    private String welcomeMessage;

    private final BasicConfiguration configuration;

    public WelcomeResource(BasicConfiguration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        // Complex Method
        return welcomeMessage;
    }

    @RequestMapping("/dynamic-configuration")
    public Map<String, Object> dynamicConfiguration() {
        // Not the best practice to use a map to store different types!
        var configMap = new HashMap<String, Object>();
        configMap.put("message", configuration.getMessage());
        configMap.put("number", configuration.getNumber());
        configMap.put("key", configuration.isValue());

        return configMap;
    }
}