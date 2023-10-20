package com.example.studentManagament.controller;

import com.example.studentManagament.entities.Instructor;
import com.example.studentManagament.repo.InstructorRepo;
import com.example.studentManagament.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor){
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.create(instructor));
    }

    @PutMapping("/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long instructorId, @RequestBody Instructor instructor){
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.update(instructor,instructorId));
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long instructorId){
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>("Instructor is deleted successfully !!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructor(){
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.getAllInstructor());
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> GetInstructor(@PathVariable Long instructorId){
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.getInstructor(instructorId));
    }

}
