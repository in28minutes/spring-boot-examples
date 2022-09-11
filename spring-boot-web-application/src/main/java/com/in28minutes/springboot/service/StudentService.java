package com.in28minutes.springboot.service;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example",
                        "Second Example"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(
                List.of(course1, course2)));

        students.add(ranga);
    }

    public Student retrieveStudent(String studentId) {

        for (Student student : students) {
            if (student.id().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);

        return student == null ? null : student.courses();

    }
}