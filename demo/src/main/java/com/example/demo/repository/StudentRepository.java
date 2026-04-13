package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByNameContainingIgnoreCase(String name);
}