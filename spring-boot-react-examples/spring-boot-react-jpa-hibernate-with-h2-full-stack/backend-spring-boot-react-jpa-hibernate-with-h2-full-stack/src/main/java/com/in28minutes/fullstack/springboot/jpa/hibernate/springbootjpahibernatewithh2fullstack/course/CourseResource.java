package com.in28minutes.fullstack.springboot.jpa.hibernate.springbootjpahibernatewithh2fullstack.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@RequestMapping("/instructors/{username}/courses")
public class CourseResource {

    private final CourseJpaRepository courseRepository;

    public CourseResource(CourseJpaRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String username,
                            @PathVariable long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Not Found with id " + id));
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
        var updatedCourse = courseRepository.save(course);

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@PathVariable String username,
                                             @RequestBody Course course) {

        course.setUsername(username);
        var createdCourse = courseRepository.save(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}