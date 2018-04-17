package com.in28minutes.springboot.rest.example.student;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
