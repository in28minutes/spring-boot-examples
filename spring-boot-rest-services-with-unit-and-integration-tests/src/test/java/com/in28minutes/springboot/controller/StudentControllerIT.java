package com.in28minutes.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.in28minutes.springboot.StudentServicesApplication;
import com.in28minutes.springboot.model.Course;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentServicesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/Student1/courses/Course1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10 Steps\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void addCourse() {

        Course course = new Course("Course1", "Spring", "10Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        HttpEntity<Course> entity = new HttpEntity<>(course, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/Student1/courses"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/students/Student1/courses/"));

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
