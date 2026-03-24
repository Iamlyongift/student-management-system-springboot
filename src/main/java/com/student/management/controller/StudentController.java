package com.student.management.controller;

import com.student.management.dtos.CreateStudentRequest;
import com.student.management.dtos.CreateStudentResponse;
import com.student.management.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    // CREATE
    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(
            @Valid @RequestBody CreateStudentRequest request) {
        CreateStudentResponse response = studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CreateStudentResponse>> getAllStudents() {
        List<CreateStudentResponse> responses = studentService.getAllStudents();
        return ResponseEntity.ok(responses);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponse> getStudentById(@PathVariable Long id) {
        CreateStudentResponse response = studentService.getStudentById(id);
        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CreateStudentResponse> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody CreateStudentRequest request) {
        CreateStudentResponse response = studentService.updateStudent(id, request);
        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        String message = studentService.deleteStudent(id);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<String> enrollStudentInCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        String message = studentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(message);
    }
}