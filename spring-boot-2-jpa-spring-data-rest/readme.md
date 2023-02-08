## Keep Learning Every Day
- **1:** [FOLLOW](https://links.in28minutes.com/lin) Ranga on LinkedIn

## Check Out Our Amazing ROADMAPS
- **1:** [AWS Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#aws-roadmap)
- **2:** [Azure Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#azure-roadmap)
- **3:** [Google Cloud Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#google-cloud-roadmap)
- **4:** [Cloud Beginner Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#cloud-beginner-roadmap)
- **5:** [DevOps Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#devops-roadmap)
- **6:** [Java Full Stack Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#java-full-stack-roadmap)
- **7:** [Java Microservices Roadmap](https://github.com/in28minutes/roadmaps/blob/main/README.md#java-microservices-roadmap)

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
        <version>3.0.2</version>
        <relativePath /> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.in28minutes.springboot.jpa.spring.data.rest.example</groupId>
    <artifactId>spring-boot-2-jpa-spring-data-rest</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>spring-boot-2-jpa-with-hibernate-and-h2</name>
    <description>Spring Boot 2, Hibernate, JPA and H2 - Example Project</description>

    <properties>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
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

### /src/main/java/com/in28minutes/springboot/jpa/spring/data/rest/example/SpringBoot2JPAWithSpringDataRestApplication.java

```java
package com.in28minutes.springboot.jpa.spring.data.rest.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.jpa.spring.data.rest.example.student.StudentDataRestRepository;

@SpringBootApplication
public class SpringBoot2JPAWithSpringDataRestApplication {

    @Autowired
    StudentDataRestRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JPAWithSpringDataRestApplication.class, args);
    }
}

```
---

### /src/main/java/com/in28minutes/springboot/jpa/spring/data/rest/example/student/Student.java

```java
package com.in28minutes.springboot.jpa.spring.data.rest.example.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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

### /src/main/java/com/in28minutes/springboot/jpa/spring/data/rest/example/student/StudentDataRestRepository.java

```java
package com.in28minutes.springboot.jpa.spring.data.rest.example.student;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentDataRestRepository extends PagingAndSortingRepository<Student, Long> {

}
```
---

### /src/main/resources/application.properties

```properties
# Enabling H2 Console
spring.h2.console.enabled=true
#Turn Statistics on
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug
# Show all queries
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type=trace

spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default
spring.jpa.defer-datasource-initialization=true
```
---

### /src/main/resources/data.sql

```
insert into student values(10001,'Ranga', 'E1234567');

insert into student values(10002,'Ravi', 'A1234568');
```
---

### /src/test/java/com/in28minutes/springboot/jpa/spring/data/rest/example/SpringBoot2JPAWithSpringDataRestApplicationTests.java

```java
package com.in28minutes.springboot.jpa.spring.data.rest.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringBoot2JPAWithSpringDataRestApplicationTests {

    @Test
    public void contextLoads() {
    }

}

```
---
