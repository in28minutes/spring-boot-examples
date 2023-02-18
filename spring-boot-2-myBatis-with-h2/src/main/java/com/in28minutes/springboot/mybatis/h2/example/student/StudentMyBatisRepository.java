package com.in28minutes.springboot.mybatis.h2.example.student;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMyBatisRepository {
    @Select("select * from student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(long id);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO student(id, name, passport) VALUES (#{id}, #{name}, #{passport})")
    int insert(Student student);

    @Update("Update student set name=#{name}, passport=#{passport} where id=#{id}")
    int update(Student student);

}
