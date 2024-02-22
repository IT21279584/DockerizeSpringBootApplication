package com.example.dockerspringapplication.service.impl;

import com.example.dockerspringapplication.entity.Student;
import com.example.dockerspringapplication.repository.StudentRepository;
import com.example.dockerspringapplication.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class.getName());
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {

        try{
            LOGGER.info("Finding all students");
            return studentRepository.findAll();
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding all students", e);
            throw e;
        }
    }

    @Override
    public Optional<Student> findStudent(Integer id) {

        try {
            LOGGER.info("Finding the student");
            return studentRepository.findById(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding a student", e);
            throw e;
        }
    }

    @Override
    public Student saveStudent(Student student) {
        try {
            LOGGER.info("Saving the student");
            return studentRepository.save(student);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while saving the student", e);
            throw e;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            LOGGER.info("Updating the student");
            return studentRepository.save(student);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while updating the student", e);
            throw e;
        }
    }

    @Override
    public void deleteStudent(Integer id) {
        try {
            LOGGER.info("Deleting the student");
            studentRepository.deleteById(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while deleting the student", e);
            throw e;
        }
    }
}
