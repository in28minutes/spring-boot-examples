package com.in28minutes.fullstack.springboot.rest.api.springbootcorscrossorigincsrf.course;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
public class CourseResource {

    private final CoursesHardcodedService service;

    public CourseResource(CoursesHardcodedService service) {
        this.service = service;
    }

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return service.findAll();
    }
}