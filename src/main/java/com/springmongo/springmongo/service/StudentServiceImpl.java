package com.springmongo.springmongo.service;

import com.springmongo.springmongo.models.Student;
import com.springmongo.springmongo.models.helpers.Address;
import com.springmongo.springmongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void createStudent(Student student) {
    }
}
