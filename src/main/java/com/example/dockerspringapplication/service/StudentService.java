package com.example.dockerspringapplication.service;


import com.example.dockerspringapplication.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudents();
    Optional<Student> findStudent(Integer id);
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Integer id);


}
