package com.in28minutes.springboot.rest.example.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"passportNumber"})
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
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
