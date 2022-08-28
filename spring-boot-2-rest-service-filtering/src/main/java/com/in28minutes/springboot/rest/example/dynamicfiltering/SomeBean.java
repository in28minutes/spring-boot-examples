package com.in28minutes.springboot.rest.example.dynamicfiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public record SomeBean(String field1,
                       String field2,
                       String field3) {
}