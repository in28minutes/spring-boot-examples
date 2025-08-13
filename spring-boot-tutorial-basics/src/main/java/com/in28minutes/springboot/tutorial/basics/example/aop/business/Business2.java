package com.in28minutes.springboot.tutorial.basics.example.aop.business;

import com.in28minutes.springboot.tutorial.basics.example.aop.data.Dao2;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    private final Dao2 dao2;

    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        //Business Logic
        return dao2.retrieveSomething();
    }
}