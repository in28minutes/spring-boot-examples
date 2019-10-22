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
import java.util.Random;

import static com.in28minutes.springboot.support.Helper.*;
import static org.junit.Assert.*;

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
        int initialSize = studentService.retrieveAllStudents().size();
        Student student = (Student) populate(Student.class);
        List<Course> courses = new ArrayList<>();
        Integer size = (Integer)Helper.getRandVal(Integer.TYPE);
        for(int i=0;i<size;i++) {
            courses.add((Course) populate(Course.class));
        }
        studentService.addStudent(student);
        for (Course cours : courses) studentService.addCourse(student.getId(), cours);

        assertEquals(studentService.retrieveCourses(student.getId()).size(), courses.size());
        int randomCourseId = (new Random()).nextInt(courses.size());
        assertEquals(studentService.retrieveCourse(student.getId(),courses.get(randomCourseId).getId()),courses.get(randomCourseId));

        Student secondStudent = (Student)populate(Student.class);
        studentService.addStudent(secondStudent);

        assertEquals(initialSize+2,studentService.retrieveAllStudents().size());
        assertEquals(0,studentService.retrieveCourses(secondStudent.getId()).size());

    }

    @Test
    public void testInvalidRetrieval()
    {
        String id=(String)getRandVal(String.class);
        assertNull("Trying to access invalid student",studentService.retrieveStudent(id));
        assertNull("Trying to access invalid course on a student",studentService.retrieveCourse(id,id));
        assertNull("Trying to access all courses for an invalid student",studentService.retrieveCourses(id));
    }
}
