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