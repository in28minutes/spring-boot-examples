package com.in28minutes.fullstack.springboot.rest.api.springbootcorscrossorigincsrf.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CoursesHardcodedService {

    private static final List<Course> courses = new ArrayList<>();
    private static long idCounter = 0;

    static {
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and Angular"));
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and React"));
        courses.add(new Course(++idCounter, "in28minutes", "Master Microservices with Spring Boot and Spring Cloud"));
        courses.add(new Course(++idCounter, "in28minutes",
                "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
    }

    public List<Course> findAll() {
        return courses;
    }
}