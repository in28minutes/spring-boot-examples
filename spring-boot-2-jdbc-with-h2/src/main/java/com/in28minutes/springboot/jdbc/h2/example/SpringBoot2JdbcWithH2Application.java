package com.in28minutes.springboot.jdbc.h2.example;

import com.in28minutes.springboot.jdbc.h2.example.student.Student;
import com.in28minutes.springboot.jdbc.h2.example.student.StudentJdbcClientRepository;
import com.in28minutes.springboot.jdbc.h2.example.student.StudentJdbcTemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final StudentJdbcTemplateRepository repository;

    private final StudentJdbcClientRepository jdbcClientRepository;

    public SpringBoot2JdbcWithH2Application (StudentJdbcTemplateRepository repository,
                                             StudentJdbcClientRepository jdbcClientRepository) {
        this.repository = repository;
        this.jdbcClientRepository = jdbcClientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
    }

    @Override
    public void run(String... args) {

        LOGGER.info("WITH JDBC TEMPLATE APPROACH...");

        LOGGER.info("Student id 10001 -> {}", repository.findById(10001L));

        LOGGER.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

        LOGGER.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

        repository.deleteById(10002L);

        LOGGER.info("All users -> {}", repository.findAll());

        LOGGER.info("With Json format users -> {}", repository.findAll());
       // repository.findAll().forEach(student -> System.out.println(student.toJSON()));

        LOGGER.info("WITH JDBC CLIENT APPROACH...");

        LOGGER.info("Student id 10001 -> {}", jdbcClientRepository.findById(10001L));

        LOGGER.info("Inserting -> {}", jdbcClientRepository.insert(new Student(10011L, "Ranga", "R1234657")));

        LOGGER.info("Update 10011 -> {}", jdbcClientRepository.update(new Student(10011L, "Ranga Karanam", "New-Passport")));

        jdbcClientRepository.deleteById(10002L);

        LOGGER.info("All users -> {}", jdbcClientRepository.findAll());


    }
}
