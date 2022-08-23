package com.mo.teknologi2.service;

import com.mo.teknologi2.model.Student;
import com.mo.teknologi2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public List<Student> fetchAll (){
        return repo.fetchAll();
    }

    public void addNew (Student s){
        repo.addNew(s);
    }

    public Student findById (int id){
        return repo.findById(id);
    }

    public void updateById (Student s){
        repo.updateById(s);
    }

    public void delete (int id){
        repo.delete(id);
    }

}
