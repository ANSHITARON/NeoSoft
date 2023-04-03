package com.security.demo.repo;


import com.security.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepo extends MongoRepository<Student, Integer>  {
   // List<Student> findAll();
}
