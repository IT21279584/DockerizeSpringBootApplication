package com.example.dockerspringapplication.controller;

import com.example.dockerspringapplication.entity.Student;
import com.example.dockerspringapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = Logger.getLogger(StudentController.class.getName());

    private StudentService studentService;

    public StudentController() {
    }
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAllStudents(){
        try{
            LOGGER.info("Finding all students");
            return studentService.findAllStudents();
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding all student", e);
            throw e;
        }

    }

    @GetMapping("/{id}")
    public Optional<Student> findStudentByID(@PathVariable("id") Integer id){
        try {
            LOGGER.info("Finding the student");
            return studentService.findStudent(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while finding a student", e);
            throw e;
        }

    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        try {
            LOGGER.info("Saving the student");
            return studentService.saveStudent(student);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while saving the student", e);
            throw e;
        }

    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        try {
            LOGGER.info("Updating the student");
            return studentService.updateStudent(student);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while updating the student", e);
            throw e;
        }

    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        try {
            LOGGER.info("Deleting the student");
            studentService.deleteStudent(id);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error occurred while deleting the student", e);
            throw e;
        }

    }


}
