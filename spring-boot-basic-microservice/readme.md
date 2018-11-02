<!---
Current Directory : /in28Minutes/git/spring-boot-examples/spring-boot-basic-microservice
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


### /spring-boot-microservice-currency-conversion-service/pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.microservice.example.currency-conversion</groupId>
	<artifactId>spring-boot-microservice-currency-conversion</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-microservice-currency-conversion</name>
	<description>Microservices with Spring Boot and Spring Cloud - Currency Conversion Service</description>

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
		<spring-cloud.version>Finchley.M8</spring-cloud.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
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

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

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

### /spring-boot-microservice-currency-conversion-service/src/main/java/com/in28minutes/springboot/microservice/example/currencyconversion/CurrencyConversionBean.java

```java
package com.in28minutes.springboot.microservice.example.currencyconversion;
import java.math.BigDecimal;

public class CurrencyConversionBean {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private BigDecimal quantity;
  private BigDecimal totalCalculatedAmount;
  private int port;

  public CurrencyConversionBean() {

  }

  public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
      BigDecimal totalCalculatedAmount, int port) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
    this.quantity = quantity;
    this.totalCalculatedAmount = totalCalculatedAmount;
    this.port = port;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotalCalculatedAmount() {
    return totalCalculatedAmount;
  }

  public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
    this.totalCalculatedAmount = totalCalculatedAmount;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}
```
---

### /spring-boot-microservice-currency-conversion-service/src/main/java/com/in28minutes/springboot/microservice/example/currencyconversion/CurrencyConversionController.java

```java
package com.in28minutes.springboot.microservice.example.currencyconversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

		logger.info("{}", response);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
```
---

### /spring-boot-microservice-currency-conversion-service/src/main/java/com/in28minutes/springboot/microservice/example/currencyconversion/CurrencyExchangeServiceProxy.java

```java
package com.in28minutes.springboot.microservice.example.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceProxy {
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable("from") String from, @PathVariable("to") String to);
}
```
---

### /spring-boot-microservice-currency-conversion-service/src/main/java/com/in28minutes/springboot/microservice/example/currencyconversion/SpringBootMicroserviceCurrencyConversionApplication.java

```java
package com.in28minutes.springboot.microservice.example.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.in28minutes.springboot.microservice.example.currencyconversion")
@EnableDiscoveryClient
public class SpringBootMicroserviceCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceCurrencyConversionApplication.class, args);
	}
}
```
---

### /spring-boot-microservice-currency-conversion-service/src/main/resources/application.properties

```properties
spring.application.name=currency-conversion-service
server.port=8100
eureka.client.service-url.default-zone=http://localhost:8761/eureka
```
---

### /spring-boot-microservice-currency-conversion-service/src/test/java/com/in28minutes/springboot/microservice/example/currencyconversion/SpringBootMicroserviceCurrencyConversionApplicationTests.java

```java
package com.in28minutes.springboot.microservice.example.currencyconversion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMicroserviceCurrencyConversionApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /spring-boot-microservice-eureka-naming-server/pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.microservice.eureka.naming.server</groupId>
	<artifactId>spring-boot-microservice-eureka-naming-server</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-microservice-eureka-naming-server</name>
	<description>Microservices with Spring Boot and Spring Cloud - Eureka Naming Server</description>

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
		<spring-cloud.version>Finchley.M8</spring-cloud.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

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

### /spring-boot-microservice-eureka-naming-server/src/main/java/com/in28minutes/springboot/microservice/eureka/naming/server/SpringBootMicroserviceEurekaNamingServerApplication.java

```java
package com.in28minutes.springboot.microservice.eureka.naming.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMicroserviceEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceEurekaNamingServerApplication.class, args);
	}
}
```
---

### /spring-boot-microservice-eureka-naming-server/src/main/resources/application.properties

```properties
spring.application.name=netflix-eureka-naming-server
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```
---

### /spring-boot-microservice-eureka-naming-server/src/test/java/com/in28minutes/springboot/microservice/eureka/naming/server/SpringBootMicroserviceEurekaNamingServerApplicationTests.java

```java
package com.in28minutes.springboot.microservice.eureka.naming.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMicroserviceEurekaNamingServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /spring-boot-microservice-forex-service/pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.microservice.example.forex</groupId>
	<artifactId>spring-boot-microservice-forex-service</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-microservice-forex-service</name>
	<description>Microservices with Spring Boot and Spring Cloud - Forex Service</description>

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
		<spring-cloud.version>Finchley.M8</spring-cloud.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
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

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

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

### /spring-boot-microservice-forex-service/src/main/java/com/in28minutes/springboot/microservice/example/forex/ExchangeValue.java

```java
package com.in28minutes.springboot.microservice.example.forex;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
  
  @Id
  private Long id;
  
  @Column(name="currency_from")
  private String from;
  
  @Column(name="currency_to")
  private String to;
  
  private BigDecimal conversionMultiple;
  private int port;
  
  public ExchangeValue() {
    
  }
  

  public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }
  
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}
```
---

### /spring-boot-microservice-forex-service/src/main/java/com/in28minutes/springboot/microservice/example/forex/ExchangeValueRepository.java

```java
package com.in28minutes.springboot.microservice.example.forex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends 
    JpaRepository<ExchangeValue, Long>{
  ExchangeValue findByFromAndTo(String from, String to);
}
```
---

### /spring-boot-microservice-forex-service/src/main/java/com/in28minutes/springboot/microservice/example/forex/ForexController.java

```java
package com.in28minutes.springboot.microservice.example.forex;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to){
    
    ExchangeValue exchangeValue = 
        repository.findByFromAndTo(from, to);
    
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    return exchangeValue;
  }
}
```
---

### /spring-boot-microservice-forex-service/src/main/java/com/in28minutes/springboot/microservice/example/forex/SpringBootMicroserviceForexServiceApplication.java

```java
package com.in28minutes.springboot.microservice.example.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceForexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceForexServiceApplication.class, args);
	}
}
```
---

### /spring-boot-microservice-forex-service/src/main/resources/application.properties

```properties
spring.application.name=forex-service
server.port=8000

spring.jpa.show-sql=true
spring.h2.console.enabled=true

eureka.client.service-url.default-zone=http://localhost:8761/eureka
```
---

### /spring-boot-microservice-forex-service/src/main/resources/data.sql

```
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10001,'USD','INR',65,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10002,'EUR','INR',75,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10003,'AUD','INR',25,0);
```
---

### /spring-boot-microservice-forex-service/src/test/java/com/in28minutes/springboot/microservice/example/forex/SpringBootMicroserviceForexServiceApplicationTests.java

```java
package com.in28minutes.springboot.microservice.example.forex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMicroserviceForexServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---
