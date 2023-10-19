package com.example.studentManagament.service.impl;

import com.example.studentManagament.entities.Course;
import com.example.studentManagament.exception.ResourceNotFoundException;
import com.example.studentManagament.repo.CourseRepo;
import com.example.studentManagament.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(long courseId) {
        courseRepo.deleteById(courseId);

    }

    @Override
    public Course getSingleCourse(Long id) {
       return courseRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course is not found of given id: "+id));

    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course updateCourse(Course course, Long courseId) {
        Optional<Course> oldCourse = courseRepo.findById(courseId);
        if(oldCourse.isPresent()){
            Course course1=oldCourse.get();
            course1.setCourseName(course.getCourseName());
            course1.setDescription(course.getDescription());
            course1.setCredits(course.getCredits());
            courseRepo.save(course1);
        }
        course.setId(courseId);
        return course;
    }
}
