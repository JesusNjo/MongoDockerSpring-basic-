package com.springmongo.springmongo.controller;

import com.springmongo.springmongo.models.Student;
import com.springmongo.springmongo.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {


    private final IStudentService studentService;

    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.getAllStudents();
    }
}
