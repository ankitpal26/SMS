package com.example.studentManagament.controller;

import com.example.studentManagament.entities.Course;
import com.example.studentManagament.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(course));
    }
    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourse());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable Long courseId){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getSingleCourse(courseId));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course course){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseService.updateCourse(course,courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.OK).body("Course is deleted !!");
    }

}
