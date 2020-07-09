package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.springboot.jpa.CourseCommandLineRunner;
import com.in28minutes.springboot.jpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	private CourseCommandLineRunner courseCommandLineRunner;
	private CourseRepository repository;

	@Autowired
	public StudentService(CourseCommandLineRunner courseCommandLineRunner,CourseRepository repository) throws Exception {
		this.courseCommandLineRunner = courseCommandLineRunner;
		this.repository = repository;
		courseCommandLineRunner.run();
		//Initialize Data
		Student ranga = new Student("Student1", "Ranga Karanam",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(repository.findById("Course1").get(), repository.findById("Course2").get())));

		Student satish = new Student("Student2", "Satish T",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(repository.findById("Course3").get(), repository.findById("Course4").get())));

		students.add(ranga);
		students.add(satish);
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

	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(130, random).toString(32);
		course.setId(randomId);

		student.getCourses().add(course);

		return course;
	}
}