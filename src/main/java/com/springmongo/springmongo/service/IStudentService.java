package com.springmongo.springmongo.service;

import com.springmongo.springmongo.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {

    public List<Student> getAllStudents();

    public void createStudent(Student student);
}
