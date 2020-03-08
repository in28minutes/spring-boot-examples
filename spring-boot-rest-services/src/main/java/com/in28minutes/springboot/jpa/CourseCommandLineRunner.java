package com.in28minutes.springboot.jpa;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.User;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter @Setter
public class CourseCommandLineRunner implements CommandLineRunner {

    private List<Course> courses= new ArrayList<>();
    private static final Logger log = LoggerFactory
            .getLogger(CourseCommandLineRunner.class);


    private CourseRepository repository;

    @Autowired
    public CourseCommandLineRunner(CourseRepository repository){
        this.repository=repository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

    repository.save(course1);
    repository.save(course2);
    repository.save(course3);
    repository.save(course4);
        for (Course course : repository.findAll()) {
            courses.add(course);
        }


    }

}
