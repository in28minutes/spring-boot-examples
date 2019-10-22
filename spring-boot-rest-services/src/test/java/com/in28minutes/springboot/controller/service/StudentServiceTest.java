package com.in28minutes.springboot.controller.service;

import com.in28minutes.springboot.jpa.CourseCommandLineRunner;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseCommandLineRunner courseCommandLineRunner;

    @Test
    public void retriveStudentTest(){
    String name=studentService.retrieveStudent("student1").getName();
        Assert.assertEquals(name,"ranga");
    }

    @Test
    public void retriveCoursesTest(){
        List<Course> courses= studentService.retrieveCourses("student1");
        Assert.assertEquals(courses,courseCommandLineRunner.getCourses());
    }

    @Test
    public void retrieveCourseIdTest(){
        Course course=studentService.retrieveCourse("student1","Course1");
        Assert.assertEquals(course.getName(),"Spring");
    }


    @Test
    public void addCourseTest(){
        boolean add=false;
        Course course1 = new Course("Course1", "NewlyAdded", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        studentService.addCourse("student1",course1);
        List<Course> courses= studentService.retrieveCourses("student1");
        for( Course course:courses){
            if(course.getName().equals("NewlyAdded")) add=true;
        }
        Assert.assertTrue(add);
    }
}
