package com.in28minutes.springboot.service;

import com.in28minutes.springboot.jpa.CourseCommandLineRunner;
import com.in28minutes.springboot.jpa.CourseRepository;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Order(30)
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	CourseRepository courseRepository;


	@Autowired
	StudentService(CourseCommandLineRunner courseCommandLineRunner) {
		try {
			courseCommandLineRunner.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseRepository = courseCommandLineRunner.getCourseRepository();
		List<Course> courses = StreamSupport.stream(courseRepository.findAll().spliterator(),false).collect(Collectors.toList());
		Student ranga = new Student("Student1", "Ranga Karanam",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
				.asList(courses.get(0), courses.get(1), courses.get(2), courses.get(3))));

		Student satish = new Student("Student2", "Satish T",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
				.asList(courses.get(0), courses.get(1), courses.get(2), courses.get(3))));

		students.add(ranga);
		students.add(satish);
	}

	public Student addStudent(Student student)
	{
		students.add(student);
		return student;
	}

	public List<Student> retrieveAllStudents() {
		return students;
	}

	public Student retrieveStudent(String studentId) {
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);
		
		if(studentId.equalsIgnoreCase("Student1")){
			throw new RuntimeException("Something went wrong");
		}

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	public Course retrieveCourse(String studentId, String courseId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		course.setId(randomId);

		student.getCourses().add(course);

		return course;
	}
}