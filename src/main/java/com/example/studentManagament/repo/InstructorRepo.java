package com.example.studentManagament.repo;

import com.example.studentManagament.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Long> {

}
