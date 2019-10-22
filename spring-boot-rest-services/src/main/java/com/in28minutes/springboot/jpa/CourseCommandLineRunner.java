package com.in28minutes.springboot.jpa;


import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;


@Component
@Order(1)
public class CourseCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CourseCommandLineRunner.class);

    private CourseRepository courseRepository;

    @Autowired
    CourseCommandLineRunner(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        courseRepository.save(new Course("Course1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example")));
        courseRepository.save(new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example")));
        courseRepository.save(new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example")));
        courseRepository.save( new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse")));
        for (Course course : courseRepository.findAll()) {
            log.info(course.toString());
        }

    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }
}
