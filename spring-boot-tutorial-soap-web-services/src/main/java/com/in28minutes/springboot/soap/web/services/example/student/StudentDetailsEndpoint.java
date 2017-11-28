package com.in28minutes.springboot.soap.web.services.example.student;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.StudentDetails;

@Endpoint
public class StudentDetailsEndpoint {

	@PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "GetStudentDetailsRequest")
	@ResponsePayload
	public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
		GetStudentDetailsResponse response = new GetStudentDetailsResponse();
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(request.getId());
		studentDetails.setName("Adam");
		studentDetails.setPassportNumber("E1234567");
		
		response.setStudentDetails(studentDetails);
		
		return response;
	}

}