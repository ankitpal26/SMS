package com.example.studentManagament.controller;

import com.example.studentManagament.entities.Student;
import com.example.studentManagament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent (@PathVariable Integer studentId,@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.updateStudent(student,studentId));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getSingleUser(@PathVariable Integer studentId){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getSingleStudent(studentId));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer studentId){
       studentService.delete(studentId);
       return new ResponseEntity<>("Item was deleted !!", HttpStatus.OK);
    }


}
