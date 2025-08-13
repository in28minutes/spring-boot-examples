package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        var courseOne = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        var courseTwo = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        var ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(List.of(courseOne, courseTwo)));

        students.add(ranga);
    }

    public Student retrieveStudent(String studentId) {
        return students.stream()
                .filter(student -> student.id().equals(studentId))
                .findAny()
                .orElse(null);
    }

    public List<Course> retrieveCourses(String studentId) {
        var student = retrieveStudent(studentId);

        return student == null ? null : student.courses();

    }
}