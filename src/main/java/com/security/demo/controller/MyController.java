package com.security.demo.controller;


import com.security.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.security.demo.repo.StudentRepo;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MyController {
   @Autowired
   private StudentRepo studentRepo;
   @PostMapping("/post")
   public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
       Student save;
        save = this.studentRepo.save(student);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudent()
    {
       List<Student> list=studentRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }


}