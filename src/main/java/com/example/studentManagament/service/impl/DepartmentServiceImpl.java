package com.example.studentManagament.service.impl;

import com.example.studentManagament.entities.Department;
import com.example.studentManagament.repo.DepartmentRepo;
import com.example.studentManagament.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department create(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Optional<Department> OldDepartment = departmentRepo.findById(id);
        if(OldDepartment.isPresent()){
            Department department1 = OldDepartment.get();
            department1.setDepartmentName(department.getDepartmentName());
            departmentRepo.save(department1);
        }
        department.setId(id);
       return department;
    }

    @Override
    public void deleteDepartment(Long id) {
            departmentRepo.deleteById(id);
    }

    @Override
    public Department getSingleDepartment(Long id) {
        return departmentRepo.findById(id).orElseThrow(()-> new RuntimeException("This id of department not found: "+id));
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }
}
