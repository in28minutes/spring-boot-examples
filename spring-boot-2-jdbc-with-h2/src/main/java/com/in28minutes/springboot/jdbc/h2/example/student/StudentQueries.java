package com.in28minutes.springboot.jdbc.h2.example.student;

/**
 * Utility class that provides SQL queries related to the Student entity.
 * This class is not meant to be instantiated.
 */
public final class StudentQueries {

    private StudentQueries() {
        // Prevent instantiation
    }

    private static final String SELECT_ALL_USERS = "select * from student";
    private static final String SELECT_USER_BY_ID = "select * from student where id=?";
    private static final String DELETE_USER_BY_ID = "delete from student where id=?";
    // Using Text Blocks (for cleaner SQL)
    private static final String INSERT_STUDENT = """
            INSERT INTO student (id, name, passport_number)
            VALUES (?, ?, ?)
            """;
    private static final String UPDATE_STUDENT = """
            UPDATE student
            SET name = ?, passport_number = ?
            WHERE id = ?
            """;


    public static String getAllStudents() {
        return SELECT_ALL_USERS;
    }

    public static String getAllStudentsById() {
        return SELECT_USER_BY_ID;
    }

    public static String getDeleteStudentById() {
        return DELETE_USER_BY_ID;
    }

    public static String getInsertStudent() {
        return INSERT_STUDENT;
    }

    public static String getUpdateStudent() {
        return UPDATE_STUDENT;
    }
}
