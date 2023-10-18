package com.example.studentManagament.service;

import com.example.studentManagament.entities.Student;

import java.util.List;

public interface StudentService {

    //create
    Student create(Student student);
    //get all student
    List<Student> getAllStudent();

    //get Single student
    Student getSingleStudent(int studentId);
    //delete
    void delete(int studentId);

    //update
    Student updateStudent(Student student, int studentId);

}
