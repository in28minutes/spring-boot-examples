package com.in28minutes.springboot.jdbc.h2.example.student;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentJdbcClientRepository {

    // Using Text Blocks (for cleaner SQL)
    private static final String SELECT_USER_BY_ID = """
            SELECT * FROM STUDENT WHERE id=:id
            """;
    private static final String DELETE_USER_BY_ID = """
            DELETE FROM STUDENT WHERE id=:id
            """;

    private final JdbcClient jdbcClient;

    public StudentJdbcClientRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Student> findAll() {
        return jdbcClient.sql(StudentQueries.getAllStudents())
                .query(Student.class)
                .list();
    }

    public Optional<Student> findById(long id) {
        return jdbcClient.sql(SELECT_USER_BY_ID)
                .param("id", id)
                .query(Student.class)
                .optional();
    }

    public void deleteById(long id) {
        jdbcClient.sql(DELETE_USER_BY_ID)
        .param("id", id)
        .update();
    }

    public int insert(Student student) {
        return jdbcClient.sql(StudentQueries.getInsertStudent())
                .params(List.of(student.getId(), student.getName(), student.getPassportNumber()))
                .update();
    }

    public int update(Student student) {
        return jdbcClient.sql(StudentQueries.getUpdateStudent())
                .params(student.getName(), student.getPassportNumber(), student.getId())
                .update();
    }
}
