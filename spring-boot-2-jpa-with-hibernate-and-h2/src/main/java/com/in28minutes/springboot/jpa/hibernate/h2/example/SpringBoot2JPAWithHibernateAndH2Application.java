package com.in28minutes.springboot.jpa.hibernate.h2.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.springboot.jpa.hibernate.h2.example.student.Student;
import com.in28minutes.springboot.jpa.hibernate.h2.example.student.StudentRepository;

@SpringBootApplication
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Override
    public void run(String... args) {

        LOGGER.info("Student id 10001 -> {}", repository.findById(10001L));

        LOGGER.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));

        LOGGER.info("Update 10003 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

        repository.deleteById(10002L);

        LOGGER.info("All users -> {}", repository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
    }

}
