package com.example.studentManagament.service;

import com.example.studentManagament.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Long enrollmentId, Enrollment enrollment);
    void deleteEnrollment(Long enrollmentId);
    List<Enrollment> getAllEnrollment();
    Enrollment getSingleEnrollment(Long enrollmentId);
}
