package com.mo.teknologi2.repository;

import com.mo.teknologi2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> fetchAll(){
        String sql = "SELECT * FROM students";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void addNew (Student s){
        String sql = "INSERT INTO students (name, age, education) VALUES (?,?,?)";
        jdbcTemplate.update(sql, s.getName(), s.getAge(), s.getEducation());
    }

    public Student findById (int id){
        String sql = "SELECT * FROM students WHERE id = ?";
        RowMapper<Student> student = new BeanPropertyRowMapper<>(Student.class);
        return jdbcTemplate.queryForObject(sql, student, id);
    }
    public void updateById (Student s){
        String sql = "UPDATE students SET name = ?, age = ?, education = ? WHERE id = ?";
        jdbcTemplate.update(sql, s.getName(), s.getAge(), s.getEducation(), s.getId());
    }

    public void delete (int id){
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
