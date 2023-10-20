package com.example.studentManagament.service.impl;

import com.example.studentManagament.entities.Enrollment;
import com.example.studentManagament.exception.ResourceNotFoundException;
import com.example.studentManagament.repo.EnrollmentRepo;
import com.example.studentManagament.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;
    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepo.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long enrollmentId, Enrollment enrollment) {

        Optional<Enrollment> optionalEnrollment=enrollmentRepo.findById(enrollmentId);
        if(optionalEnrollment.isPresent()){
          Enrollment enrollment1 = optionalEnrollment.get();
          enrollment1.setEnrollmentDate(enrollment.getEnrollmentDate());
          enrollment1.setGrade(enrollment.getGrade());
          enrollment1.setCourseId(enrollment.getCourseId());
          enrollment1.setStudentId(enrollment.getStudentId());
          enrollmentRepo.save(enrollment1);
        }
        enrollment.setEnrollmentId(enrollmentId);
        return enrollment;
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
      enrollmentRepo.deleteById(enrollmentId);
    }

    @Override
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepo.findAll();
    }

    @Override
    public Enrollment getSingleEnrollment(Long enrollmentId) {
        return enrollmentRepo.findById(enrollmentId).orElseThrow(() -> new ResourceNotFoundException("This enrollment is not found at id: "+enrollmentId));
    }
}
