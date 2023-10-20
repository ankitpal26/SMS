package com.example.studentManagament.controller;

import com.example.studentManagament.entities.Enrollment;
import com.example.studentManagament.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> create(Enrollment enrollment){
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentService.createEnrollment(enrollment));
    }

    @PutMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long enrollmentId, Enrollment enrollment){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(enrollmentService.updateEnrollment(enrollmentId,enrollment));
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<String> delete(@PathVariable Long enrollmentId){
        enrollmentService.deleteEnrollment(enrollmentId);
        return new  ResponseEntity<>("Enrollment is deleted !!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollment(){
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.getAllEnrollment());
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> getSingleEnrollment(@PathVariable Long enrollmentId){
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.getSingleEnrollment(enrollmentId));
    }


}
