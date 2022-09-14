<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-tutorial-basics-configuration
-->

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
        <version>3.0.0-M4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.in28minutes.springboot.tutorial.basics.application.configuration</groupId>
    <artifactId>spring-boot-tutorial-basics-configuration</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>spring-boot-tutorial-basics-configuration</name>
    <description>Spring Boot Tutorial - Application Configuration with Profiles and YAML</description>

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

### /src/main/java/com/in28minutes/springboot/tutorial/basics/application/configuration/BasicConfiguration.java

```java
package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicConfiguration {
    private boolean value;
    private String message;
    private int number;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/application/configuration/SpringBootTutorialBasicsConfigurationApplication.java

```java
package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringBootTutorialBasicsConfigurationApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootTutorialBasicsConfigurationApplication.class, args);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Profile("dev")
    @Bean
    public String devBean() {
        return "dev";
    }

    @Profile("qa")
    @Bean
    public String qaBean() {
        return "qa";
    }

    @Profile("prod")
    @Bean
    public String prodBean() {
        return "prod";
    }
}

```
---

### /src/main/java/com/in28minutes/springboot/tutorial/basics/application/configuration/WelcomeResource.java

```java
package com.in28minutes.springboot.tutorial.basics.application.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    private BasicConfiguration configuration;

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        // Complex Method
        return welcomeMessage;
    }

    @RequestMapping("/dynamic-configuration")
    public Map<String, Object> dynamicConfiguration() {
        // Not the best practice to use a map to store different types!
        Map<String, Object> configMap = new HashMap<>();
        configMap.put("message", configuration.getMessage());
        configMap.put("number", configuration.getNumber());
        configMap.put("key", configuration.isValue());
        return configMap;
    }
}
```
---

### /src/main/resources/application-dev.properties

```properties
welcome.message=Welcome message from property file! Welcome to ${app.name} in DEV
basic.message=Dynamic Message in DEV
```
---

### /src/main/resources/application-prod.properties

```properties
logging.level.org.springframework=INFO
```
---

### /src/main/resources/application.properties

```properties
spring.profiles.active=dev
logging.level.org.springframework.web.servlet=DEBUG
app.name=in28Minutes
welcome.message=Welcome message from property file! Welcome to ${app.name}
basic.value=true
basic.message=Dynamic Message
basic.number=100
```
---

### /src/main/resources/application.yaml

```
logging:
  level:
    org.springframework: INFO
    org.springframework.web.servlet: DEBUG

basic:
  value: true
  message: Dynamic Message YAML
  number: 100
```
---

### /src/test/java/com/in28minutes/springboot/tutorial/basics/application/configuration/SpringBootTutorialBasicsConfigurationApplicationTests.java

```java
package com.in28minutes.springboot.tutorial.basics.application.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringBootTutorialBasicsConfigurationApplicationTests {

    @Test
    public void contextLoads() {
    }

}
```
---
