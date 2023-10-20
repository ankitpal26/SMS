package com.example.studentManagament.service.impl;

import com.example.studentManagament.entities.Instructor;
import com.example.studentManagament.exception.ResourceNotFoundException;
import com.example.studentManagament.repo.InstructorRepo;
import com.example.studentManagament.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Instructor create(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor, Long instructorId) {
        Optional<Instructor> instructorOptional=instructorRepo.findById(instructorId);
        if(instructorOptional.isPresent()){
            Instructor instructor1 = instructorOptional.get();
            instructor1.setEmail(instructor.getEmail());
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setPhone(instructor.getPhone());
            instructorRepo.save(instructor1);
        }
        instructor.setId(instructorId);
        return instructor;
    }

    @Override
    public void deleteInstructor(Long instructorId) {
         instructorRepo.deleteById(instructorId);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructor(Long instructorId) {
        return instructorRepo.findById(instructorId).orElseThrow(()-> new ResourceNotFoundException("Instructor is not found of this id :"+instructorId));
    }
}
