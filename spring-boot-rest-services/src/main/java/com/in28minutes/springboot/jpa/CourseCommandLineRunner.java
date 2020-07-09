package com.in28minutes.springboot.jpa;

import com.in28minutes.springboot.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private CourseRepository repository;
    @Autowired
    public CourseCommandLineRunner(CourseRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(String... args) throws Exception {

        repository.save(new Course("Course1", "Spring", "10 Steps",
                                   Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example")));

        repository.save(new Course("Course2", "Spring MVC", "10 Examples",
                                    Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example")));

        repository.save(new Course("Course3", "Spring Boot", "6K Students",
                                    Arrays.asList("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example")));

        repository.save(new Course("Course4", "Maven", "Most popular maven course on internet!",
                                    Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse")));

        for (Course course : repository.findAll()) {
            log.info(course.toString());
        }
    }
}
