package com.in28minutes.springboot.jpa;

import com.in28minutes.springboot.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
}
