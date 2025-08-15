package com.in28minutes.springboot.jpa.spring.data.rest.example.student;

import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentDataRestRepository extends PagingAndSortingRepository<@NonNull Student, @NonNull Long> {

}
