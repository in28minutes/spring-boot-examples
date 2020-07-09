package com.in28minutes.springboot.service;

import com.in28minutes.springboot.jpa.CourseCommandLineRunner;
import com.in28minutes.springboot.jpa.CourseRepository;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    private Course mockCourse = new Course("Course1", "Spring", "10 Steps", Arrays
            .asList("Learn Maven", "Import Project", "First Example",
                    "Second Example"));

    private Student mockStudent = new Student("Student2", "Satish T",
            "Hiker, Programmer and Architect", new ArrayList<>(Arrays
            .asList(mockCourse)));

    @Test
    public void retrieveAllStudents() {
        System.out.println(service);
        System.out.println(service.retrieveAllStudents());
        assertEquals(false,service.retrieveAllStudents().isEmpty());
    }

    @Test
    public void retrieveStudent() {
        assertEquals(mockStudent.getId(),service.retrieveStudent("Student2").getId());
        assertNull(service.retrieveStudent(Mockito.anyString()));
    }

    @Test
    public void retrieveCourses() {
        assertEquals(false,service.retrieveCourses("Student2").isEmpty());
        assertNull(service.retrieveCourses(Mockito.anyString()));
    }

    @Test
    public void retrieveCourse() {
        assertEquals("Course3",service.retrieveCourse("Student2","Course3").getId());
        assertNull(service.retrieveCourse(Mockito.anyString(),"Course3"));
        assertNull(service.retrieveCourse("Student2",Mockito.anyString()));
    }

    @Test
    public void addCourse() {
        assertNull(service.addCourse(Mockito.anyString(),Mockito.any(Course.class)));
        assertEquals(mockCourse,service.addCourse("Student2",mockCourse));
    }
}