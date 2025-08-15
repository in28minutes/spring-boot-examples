package com.in28minutes.springboot.jdbc.h2.example.student;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            var student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPassportNumber(rs.getString("passport_number"));
            return student;
        }

    }

    public List<Student> findAll() {
        return jdbcTemplate.query(StudentQueries.getAllStudents(), new StudentRowMapper());
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject(StudentQueries.getAllStudentsById(), new BeanPropertyRowMapper<>(Student.class), id);
    }

    public void deleteById(long id) {
        jdbcTemplate.update(StudentQueries.getDeleteStudentById(), id);
    }

    public int insert(Student student) {
        return jdbcTemplate.update(StudentQueries.getInsertStudent(),
                student.getId(), student.getName(), student.getPassportNumber());
    }

    public int update(Student student) {
        return jdbcTemplate.update(StudentQueries.getUpdateStudent(),
                student.getName(), student.getPassportNumber(), student.getId());
    }

}
