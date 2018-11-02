<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-2-rest-service-with-swagger
-->

### Our Best Selling Spring Boot Courses

[![Image](https://www.in28minutes.com/course-promotional-images/Master-Microservices-with-Spring-Boot-and-Spring-Cloud.png "Master Microservices with Spring Boot and Spring Cloud")](https://www.udemy.com/microservices-with-spring-boot-and-spring-cloud/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Spring-Framework-Master-Class---Beginner-to-Expert.png "Spring Master Class - Beginner to Expert")](https://www.udemy.com/spring-tutorial-for-beginners/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Master-Java-Web-Services-and-REST-API-with-Spring-Boot.png "Master Java Web Services and REST API with Spring Boot")](https://www.udemy.com/spring-web-services-tutorial/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Spring-Framework-Interview-Guide-200-Questions-Answers.png "Spring Framework Interview Guide - 200+ Questions & Answers")](https://www.udemy.com/spring-interview-questions-and-answers/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Learn-Spring-Boot-in-100-Steps---Beginner-to-Expert.png "Learn Spring Boot in 100 Steps - Beginner to Expert")](https://www.udemy.com/spring-boot-tutorial-for-beginners/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Master-Java-Unit-Testing-with-Spring-Boot-Mockito.png "Master Java Unit Testing with Spring Boot & Mockito")](https://www.udemy.com/learn-unit-testing-with-spring-boot/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Your-First-Steps-From-Programmer-To-Software-Architect.png "Your First Steps from Programmer to Software Architect")](https://www.udemy.com/software-architect-course-first-steps/?couponCode=LEARN-2019)

[![Image](https://www.in28minutes.com/course-promotional-images/Master-Hibernate-and-JPA-with-Spring-Boot-in-100-Steps.png "Master Hibernate and JPA with Spring Boot in 100 Steps")](https://www.udemy.com/hibernate-jpa-tutorial-for-beginners-in-100-steps/?couponCode=LEARN-2019)

### More Courses and Videos From in28Minutes
- https://github.com/in28minutes/learn

## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.rest.example</groupId>
	<artifactId>spring-boot-2-rest-service-swagger</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-2-rest-service</name>
	<description>Spring Boot 2 and REST - Example Project</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-hateoas</artifactId>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.4.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.4.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
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
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
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
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
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

### /src/main/java/com/in28minutes/springboot/rest/example/SpringBoot2RestServiceApplication.java

```java
package com.in28minutes.springboot.rest.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2RestServiceApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/Student.java

```java
package com.in28minutes.springboot.rest.example.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the student. ")
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	private String passportNumber;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
		
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentNotFoundException.java

```java
package com.in28minutes.springboot.rest.example.student;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentRepository.java

```java
package com.in28minutes.springboot.rest.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentResource.java

```java
package com.in28minutes.springboot.rest.example.student;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
public class StudentResource {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	@ApiOperation(value = "Find student by id",
    notes = "Also returns a link to retrieve all students with rel - all-students")
	public Resource<Student> retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);

		Resource<Student> resource = new Resource<Student>(student.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

		resource.add(linkTo.withRel("all-students"));

		return resource;
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/swagger/ApiDocumentationConfig.java

```java
package com.in28minutes.springboot.rest.example.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Awesome Resources",
                version = "V12.0.12",
                title = "Awesome Resource API",
                contact = @Contact(
                   name = "Ranga Karanam", 
                   email = "ranga.karanam@in28minutes.com", 
                   url = "http://www.in28minutes.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://in28minutes.com")
)
public interface ApiDocumentationConfig {

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/swagger/SwaggerConfig.java

```java
package com.in28minutes.springboot.rest.example.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public static final Contact DEFAULT_CONTACT = new Contact(
      "Ranga Karanam", "http://www.in28minutes.com", "in28minutes@gmail.com");
  
  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
      "Awesome API Title", "Awesome API Description", "1.0",
      "urn:tos", DEFAULT_CONTACT, 
      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
      new HashSet<String>(Arrays.asList("application/json",
          "application/xml"));

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(DEFAULT_API_INFO)
        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
  }
}
```
---

### /src/main/resources/application.properties

```properties
```
---

### /src/main/resources/data.sql

```
insert into student
values(10001,'Ranga', 'E1234567');

insert into student
values(10002,'Ravi', 'A1234568');
```
---

### /src/test/java/com/in28minutes/springboot/rest/example/SpringBoot2RestServiceApplicationTests.java

```java
package com.in28minutes.springboot.rest.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2RestServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---
