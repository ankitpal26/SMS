package com.example.studentManagament.service.impl;

import com.example.studentManagament.entities.Student;
import com.example.studentManagament.exception.ResourceNotFoundException;
import com.example.studentManagament.repo.StudentRepo;
import com.example.studentManagament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student create(Student student) {

        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getSingleStudent(int studentId) {
        return studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("This id student is not find : "+ studentId));
    }

    @Override
    public void delete(int studentId) {
        studentRepo.deleteById(studentId);
    }


    @Override
    public Student updateStudent(Student student, int studentId) {
        Optional<Student> student1=studentRepo.findById(studentId);

        if(student1.isPresent()) {
            Student studentUpdate = student1.get();
            studentUpdate.setAddress(student.getAddress());
            studentUpdate.setEmail(student.getEmail());
            studentUpdate.setMobile(student.getMobile());
            studentUpdate.setFirstName(student.getFirstName());
            studentUpdate.setLastName(student.getLastName());
            studentUpdate.setMobile(student.getMobile());
            Student  newStudent= studentRepo.save(studentUpdate);
        }
        return student;
    }
}
