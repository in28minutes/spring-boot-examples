package com.in28minutes.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.in28minutes.springboot.jpa.CourseCommandLineRunner;
import com.in28minutes.springboot.jpa.UserCommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;

@Component
public class StudentService {
	private UserCommandLineRunner userCommandLineRunner;
	private static List<Student> students = new ArrayList<>();
	@Autowired
	StudentService(UserCommandLineRunner userCommandLineRunner, CourseCommandLineRunner courseCommandLineRunner){
		try {
				userCommandLineRunner.run(); }
		catch(Exception e){
			e.printStackTrace();
		}
		Student ranga=new Student("Student1","ranga","cse",courseCommandLineRunner.getCourses());
		Student banga=new Student("Student2","banga","ece",courseCommandLineRunner.getCourses());
		students.add(ranga);
		students.add(banga);
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
		
//		if(studentId.equalsIgnoreCase("Student1")){
//			throw new RuntimeException("Something went wrong");
//		}

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