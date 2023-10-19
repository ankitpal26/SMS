package com.example.studentManagament.service;

import com.example.studentManagament.entities.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    void deleteCourse(long courseId);
    Course getSingleCourse(Long id);
    List<Course> getAllCourse();
    Course updateCourse(Course course, Long courseId);
}
