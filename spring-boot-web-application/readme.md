<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-web-application
-->

## Learn from the Top 5 Best Selling Courses

[![Image](https://www.springboottutorial.com/images/Course-Master-Microservices-with-Spring-Boot-and-Spring-Cloud.png "Master Microservices with Spring Boot and Spring Cloud")](https://links.in28minutes.com/in28minutes-Microservices)

[![Image](https://www.springboottutorial.com/images/Course-Spring-Framework-Master-Class---Beginner-to-Expert.png "Spring Master Class - Beginner to Expert")](https://links.in28minutes.com/in28minutes-Spring)

[![Image](https://www.springboottutorial.com/images/Course-DevOps.png "DevOps Course")](https://links.in28minutes.com/DevOps-SBT)
[![Image](https://www.springboottutorial.com/images/Course-go-serverless.png "Go Serverless with AWS Lambda and Azure Functions")](https://links.in28minutes.com/serverless-sbt)

[![Image](https://www.springboottutorial.com/images/Course-Go-Full-Stack-With-SpringBoot-And-Angular.png "Go Full Stack with Spring Boot and Angular")](https://links.in28minutes.com/in28minutes-angular)

[![Image](https://www.springboottutorial.com/images/Course-Go-Full-Stack-With-Spring-Boot-and-React.png "Go Full Stack with Spring Boot and React")](https://links.in28minutes.com/in28minutes-React)

## The Amazing in28Minutes Learning Paths will help you reskill.

- [Learning Path 01 - Spring and Spring Boot Web Applications and API Developer](https://links.in28minutes.com/in28minutes-LP-01)
- [Learning Path 02 - Full Stack Developer with Spring Boot, React & Angular](https://links.in28minutes.com/in28minutes-LP-02)
- [Learning Path 03 - Cloud Microservices Developer with Docker and Kubernetes](https://links.in28minutes.com/in28minutes-LP-03)
- [Learning Path 04 - Learn Cloud with Spring Boot, AWS, Azure and PCF](https://links.in28minutes.com/in28minutes-LP-04)
- [Learning Path 05 - Learn AWS with Microservices, Docker and Kubernetes](https://links.in28minutes.com/in28minutes-LP-05)

## Example of Complete Code

### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.0-M4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.in28minutes.springboot</groupId>
    <artifactId>student-services-security</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>student-services</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>

</project>
```

---

### /src/main/java/com/in28minutes/springboot/controller/LoginController.java

```java
package com.in28minutes.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginPage(ModelMap model) {
        model.put("name", "in28Minutes");
        return "welcome";
    }

}
```

---

### /src/main/java/com/in28minutes/springboot/controller/StudentController.java

```java
package com.in28minutes.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/courses")
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }
}
```

---

### /src/main/java/com/in28minutes/springboot/model/Course.java

```java
package com.in28minutes.springboot.model;

import java.util.List;

public record Course(String id,
                     String name,
                     String description,
                     List<String> steps) {
}
```

---

### /src/main/java/com/in28minutes/springboot/model/Student.java

```java
package com.in28minutes.springboot.model;

import java.util.List;

public record Student(String id,
                      String name,
                      String description,
                      List<Course> courses) {
}
```

---

### /src/main/java/com/in28minutes/springboot/security/SecurityConfig.java

```java
package com.in28minutes.springboot.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //LDAP or Database
    //In Memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("admin1", "secret1");

        return new InMemoryUserDetailsManager(userDetails1);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //All URLs are protected
    //A login form is shown for unauthorized requests
    //CSRF disable
    //Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.httpBasic(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}

```

---

### /src/main/java/com/in28minutes/springboot/service/StudentService.java

```java
package com.in28minutes.springboot.service;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final List<Student> students = new ArrayList<>();

    static {
        // Initialize Data
        Course course1 = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example",
                        "Second Example"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(
                List.of(course1, course2)));

        students.add(ranga);
    }

    public Student retrieveStudent(String studentId) {

        for (Student student : students) {
            if (student.id().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Course> retrieveCourses(String studentId) {
        Student student = retrieveStudent(studentId);

        return student == null ? null : student.courses();

    }
}
```

---

### /src/main/java/com/in28minutes/springboot/StudentServicesApplication.java

```java
package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServicesApplication.class, args);
    }
}
```

---

### /src/main/resources/application.properties

```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

---

### /src/main/webapp/WEB-INF/jsp/welcome.jsp

```
<div class="container">
    Welcome ${name}!! 
</div>
```

---

### /src/test/java/com/in28minutes/springboot/StudentServicesApplicationTests.java

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServicesApplicationTests {

    @Test
    public void contextLoads() {
    }

}
```

---
