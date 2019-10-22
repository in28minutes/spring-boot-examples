package com.in28minutes.springboot.jpa;

import java.util.List;

import com.in28minutes.springboot.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}