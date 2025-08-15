package com.in28minutes.springboot.rest.example.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"passportNumber"})
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    private String passportNumber;

}
