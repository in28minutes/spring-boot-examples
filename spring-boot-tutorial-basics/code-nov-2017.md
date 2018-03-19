<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-tutorial-basics
-->

## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.tutorial.basics.example</groupId>
	<artifactId>spring-boot-tutorial-basics</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-tutorial-basics</name>
	<description>Spring Boot Tutorial - Basic Concept Examples</description>

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
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
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

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/AfterAopAspect.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.in28minutes.springboot.basics.example.aop.business.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@After(value = "execution(* com.in28minutes.springboot.basics.example.aop.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/business/Business1.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.example.aop.data.Dao1;

@Service
public class Business1 {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Dao1 dao1;
	
	public String calculateSomething(){
		//Business Logic
		String value = dao1.retrieveSomething();
		logger.info("In Business - {}", value);
		return value;
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/business/Business2.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.example.aop.data.Dao2;

@Service
public class Business2 {
	
	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething(){
		//Business Logic
		return dao2.retrieveSomething();
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/CommonJoinPointConfig.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop;
import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.in28minutes.springboot.basics.example.aop.data.*.*(..))")
	public void dataLayerExecution(){}
	
	@Pointcut("execution(* com.in28minutes.springboot.basics.example.aop.business.*.*(..))")
	public void businessLayerExecution(){}
	
	@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution(){}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao(){}
	
	@Pointcut("within(com.in28minutes.springboot.basics.example.aop.data..*)")
	public void dataLayerExecutionWithWithin(){}

	@Pointcut("@annotation(com.in28minutes.springboot.basics.example.aop.TrackTime)")
	public void trackTimeAnnotation(){}

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/data/Dao1.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop.data;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	
	public String retrieveSomething(){
		return "Dao1";
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/data/Dao2.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String retrieveSomething(){
		return "Dao2";
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/aop/UserAccessAspect.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("execution(* com.in28minutes.springboot.basics.example.aop.data.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/application/context/java/JavaConfiguration.java

```java
package com.in28minutes.springboot.tutorial.basics.example.application.context.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
	
	@Bean
	public String someDummyBean1() {
		return "someDummyBean1";
	}
	
	@Bean
	public String someDummyBean2() {
		return "someDummyBean2";
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/application/context/java/XmlConfiguration.java

```java
package com.in28minutes.springboot.tutorial.basics.example.application.context.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
public class XmlConfiguration {
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/SpringBootTutorialBasicsApplication.java

```java
package com.in28minutes.springboot.tutorial.basics.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTutorialBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootTutorialBasicsApplication.class, args);

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/student/Student.java

```java
package com.in28minutes.springboot.tutorial.basics.example.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
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

	public Student(String name, String passportNumber) {
		super();
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

	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s, passportNumber=%s]", id, name, passportNumber);
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/student/StudentRepository.java

```java
package com.in28minutes.springboot.tutorial.basics.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/student/StudentResource.java

```java
package com.in28minutes.springboot.tutorial.basics.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/unittesting/BusinessService.java

```java
package com.in28minutes.springboot.tutorial.basics.example.unittesting;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {
	private DataService dataService;

	public BusinessService(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;

		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/example/unittesting/DataService.java

```java
package com.in28minutes.springboot.tutorial.basics.example.unittesting;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
	public int[] retrieveAllData() {
		// Some dummy data
		// Actually this should talk to some database to get all the data
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
```
---

### /src/main/resources/application.properties

```properties
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=INFO
```
---

### /src/main/resources/applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- <context:component-scan base-package="com.in28minutes.spring.basics"/> -->

	<bean id="xmlStringBean1" class="java.lang.String">
		<constructor-arg value="stringBean1" />
	</bean>

	<bean id="xmlStringBean2" class="java.lang.String">
		<constructor-arg value="stringBean2" />
	</bean>

</beans>
```
---

### /src/test/java/com/in28minutes/springboot/tutorial/basics/example/aop/BusinessAopSpringBootTest.java

```java
package com.in28minutes.springboot.tutorial.basics.example.aop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business1;
import com.in28minutes.springboot.tutorial.basics.example.aop.business.Business2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Business1 business1;

	@Autowired
	private Business2 business2;

	@Test
	public void invokeAOPStuff() {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}
}
```
---

### /src/test/java/com/in28minutes/springboot/tutorial/basics/example/SpringBootTutorialBasicsApplicationTests.java

```java
package com.in28minutes.springboot.tutorial.basics.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTutorialBasicsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /src/test/java/com/in28minutes/springboot/tutorial/basics/example/unittest/BusinessServicesMockSpringContextTest.java

```java
package com.in28minutes.springboot.tutorial.basics.example.unittest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.springboot.tutorial.basics.example.unittesting.BusinessService;
import com.in28minutes.springboot.tutorial.basics.example.unittesting.DataService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServicesMockSpringContextTest {

	@MockBean
	DataService dataServiceMock;

	@Autowired
	BusinessService businessImpl;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}
```
---

### /src/test/java/com/in28minutes/springboot/tutorial/basics/example/unittest/BusinessServicesMockTest.java

```java
package com.in28minutes.springboot.tutorial.basics.example.unittest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.springboot.tutorial.basics.example.unittesting.BusinessService;
import com.in28minutes.springboot.tutorial.basics.example.unittesting.DataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServicesMockTest {

	@Mock
	DataService dataServiceMock;

	@InjectMocks
	BusinessService businessImpl;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}
```
---
