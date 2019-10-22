package com.in28minutes.springboot;


import com.in28minutes.springboot.jpa.CourseRepository;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.service.StudentService;
import com.in28minutes.springboot.support.Helper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.in28minutes.springboot.support.Helper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests
{
    @Autowired
    private  StudentService studentService;

    @Test
    public void testInit()
    {
        assertNotNull(studentService);

    }

    @Test
    public void testInsert()
    {
        Student student = (Student) populate(Student.class);
        List<Course> courses = new ArrayList<>();
        Integer size = (Integer)Helper.getRandVal(Integer.TYPE);
        for(int i=0;i<size;i++) {
            courses.add((Course) populate(Course.class));
        }
        studentService.addStudent(student);
        for (Course cours : courses) studentService.addCourse(student.getId(), cours);

        assertEquals(studentService.retrieveStudent(student.getId()).getCourses().size(), courses.size());
    }
}
