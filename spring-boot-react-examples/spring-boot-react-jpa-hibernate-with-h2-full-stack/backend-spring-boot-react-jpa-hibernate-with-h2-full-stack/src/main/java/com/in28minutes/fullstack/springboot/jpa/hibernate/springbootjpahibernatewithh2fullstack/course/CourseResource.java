package com.in28minutes.fullstack.springboot.jpa.hibernate.springbootjpahibernatewithh2fullstack.course;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@RequestMapping("/instructors/{username}/courses")
public class CourseResource {

    @Autowired
    private CourseJpaRepository courseRepository;

    @GetMapping()
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String username,
                            @PathVariable long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Not Found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username,
                                             @PathVariable long id) {
        courseRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username,
											   @PathVariable long id,
                                               @RequestBody Course course) {
        course.setUsername(username);
        Course courseUpdated = courseRepository.save(course);

        return new ResponseEntity<Course>(courseUpdated, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> createCourse(@PathVariable String username,
											 @RequestBody Course course) {

        course.setUsername(username);
        Course createdCourse = courseRepository.save(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}