package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

    private final SecureRandom random = new SecureRandom();

    static {
        //Initialize Data
        var courseOne = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        var courseTwo = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        var courseThree = new Course("Course3", "Spring Boot", "6K Students",
                List.of("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));

        var courseFour = new Course("Course4", "Maven", "Most popular maven course on internet!",
                List.of("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

        var ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        var satish = new Student("Student2", "Satish T", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        students.add(ranga);
        students.add(satish);
    }

    public List<Student> retrieveAllStudents() {
        return students;
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

    public Course retrieveCourse(String studentId, String courseId) {
        var student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }

        return student.courses().stream()
                .filter(course -> course.id().equals(courseId))
                .findAny()
                .orElse(null);

    }

    public Course addCourse(String studentId, Course course) {
        var student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);

        student.courses()
                .add(course);

        return course;
    }
}