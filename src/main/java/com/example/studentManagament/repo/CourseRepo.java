package com.example.studentManagament.repo;

import com.example.studentManagament.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {

}
