package com.example.studentManagament.controller;

import com.example.studentManagament.entities.Department;
import com.example.studentManagament.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        return  ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> createDepartment(@PathVariable Long id, @RequestBody Department department){
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentService.updateDepartment(id, department));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getSingleDepartment(id));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments(){
        return  ResponseEntity.status(HttpStatus.CREATED).body(departmentService.getAllDepartment());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return  new ResponseEntity<>("department is deleted successfully",HttpStatus.OK);
    }
}
