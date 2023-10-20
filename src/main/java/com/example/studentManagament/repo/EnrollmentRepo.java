package com.example.studentManagament.repo;

import com.example.studentManagament.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

}

