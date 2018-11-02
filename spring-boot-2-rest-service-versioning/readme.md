<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-2-rest-service-versioning
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
	<artifactId>spring-boot-2-rest-service-versioning</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-2-rest-service</name>
	<description>Spring Boot 2 and REST - Example Project</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
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

### /src/main/java/com/in28minutes/springboot/rest/example/versioning/Name.java

```java
package com.in28minutes.springboot.rest.example.versioning;
public class Name {
  private String firstName;
  private String lastName;

  public Name() {
  }

  public Name(String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/versioning/StudentV1.java

```java
package com.in28minutes.springboot.rest.example.versioning;
public class StudentV1 {
  private String name;

  public StudentV1() {
    super();
  }
  
  public StudentV1(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/versioning/StudentV2.java

```java
package com.in28minutes.springboot.rest.example.versioning;
public class StudentV2 {
  private Name name;

  public StudentV2() {
    super();
  }

  public StudentV2(Name name) {
    super();
    this.name = name;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/versioning/StudentVersioningController.java

```java
package com.in28minutes.springboot.rest.example.versioning;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersioningController {

  @GetMapping("v1/student")
  public StudentV1 studentV1() {
    return new StudentV1("Bob Charlie");
  }

  @GetMapping("v2/student")
  public StudentV2 studentV2() {
    return new StudentV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(value = "/student/param", params = "version=1")
  public StudentV1 paramV1() {
    return new StudentV1("Bob Charlie");
  }

  @GetMapping(value = "/student/param", params = "version=2")
  public StudentV2 paramV2() {
    return new StudentV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(value = "/student/header", headers = "X-API-VERSION=1")
  public StudentV1 headerV1() {
    return new StudentV1("Bob Charlie");
  }

  @GetMapping(value = "/student/header", headers = "X-API-VERSION=2")
  public StudentV2 headerV2() {
    return new StudentV2(new Name("Bob", "Charlie"));
  }

  @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v1+json")
  public StudentV1 producesV1() {
    return new StudentV1("Bob Charlie");
  }

  @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v2+json")
  public StudentV2 producesV2() {
    return new StudentV2(new Name("Bob", "Charlie"));
  }

}
```
---

### /src/main/resources/application.properties

```properties
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
