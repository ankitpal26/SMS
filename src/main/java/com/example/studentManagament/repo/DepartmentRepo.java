package com.example.studentManagament.repo;

import com.example.studentManagament.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
