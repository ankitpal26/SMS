package com.example.studentManagament.service;

import com.example.studentManagament.entities.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department);

    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
    Department getSingleDepartment(Long id);
    List<Department> getAllDepartment();
}
