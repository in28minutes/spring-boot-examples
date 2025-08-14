package com.in28minutes.fullstack.springboot.jpa.hibernate.springbootjpahibernatewithh2fullstack.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByUsername(String username);
}