package com.student.management.service;

import com.student.management.dtos.CreateStudentRequest;
import com.student.management.dtos.CreateStudentResponse;
import java.util.List;

public interface StudentService {
    CreateStudentResponse createStudent(CreateStudentRequest request);
    List<CreateStudentResponse> getAllStudents();
    CreateStudentResponse getStudentById(Long id);
    CreateStudentResponse updateStudent(Long id, CreateStudentRequest request);
    String deleteStudent(Long id);
    String enrollStudentInCourse(Long studentId, Long courseId);
}

//return type    method name    parameters
//────────────   ───────────    ──────────
//CreateStudentResponse createStudent(CreateStudentRequest request)
//     ↑                                      ↑
//what comes out                        what goes in