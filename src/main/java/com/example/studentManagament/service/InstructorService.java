package com.example.studentManagament.service;

import com.example.studentManagament.entities.Instructor;

import java.util.List;

public interface InstructorService {


    Instructor create(Instructor instructor);
    Instructor update(Instructor instructor, Long instructorId);
    void deleteInstructor(Long instructorId);
     List<Instructor> getAllInstructor();
     Instructor getInstructor(Long instructorId);

}
