package com.springmongo.springmongo.repository;

import com.springmongo.springmongo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findStudentByEmail(String email);

}
