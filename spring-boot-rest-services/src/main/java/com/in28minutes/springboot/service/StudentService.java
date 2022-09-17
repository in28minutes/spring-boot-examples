package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

	private final SecureRandom random = new SecureRandom();

    static {
        //Initialize Data
        Course courseOne = new Course("Course1", "Spring", "10Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseTwo = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseThree = new Course("Course3", "Spring Boot", "6K Students",
                List.of("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));

        Course courseFour = new Course("Course4", "Maven", "Most popular maven course on internet!",
                List.of("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        Student satish = new Student("Student2", "Satish T", "Hiker, Programmer and Architect",
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
        Student student = retrieveStudent(studentId);

        if (studentId.equalsIgnoreCase("Student1")) {
            throw new RuntimeException("Something went wrong");
        }

        return student == null ? null : student.courses();
    }

    public Course retrieveCourse(String studentId, String courseId) {
        Student student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }

		return student.courses().stream()
				.filter(course -> course.id().equals(courseId))
				.findAny()
				.orElse(null);
    }

	public Course addCourse(String studentId, Course course) {
        Student student = retrieveStudent(studentId);

        if (student == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        new Course(randomId, "", "", Collections.singletonList(""));

        student.courses().add(course);

        return course;
    }
}