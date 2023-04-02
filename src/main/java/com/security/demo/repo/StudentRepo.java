package com.security.demo.repo;


import com.security.demo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Integer>  {

}
