package com.student.management.controller;

import com.student.management.dtos.CreateCourseRequest;
import com.student.management.dtos.CreateCourseResponse;
import com.student.management.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CreateCourseResponse> addCourse(
            @Valid @RequestBody CreateCourseRequest request) {
        CreateCourseResponse response = courseService.createCourse(request); // ✅
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CreateCourseResponse>> getAllCourse() { // ✅ List!
        List<CreateCourseResponse> response = courseService.getAllCourse();
        return ResponseEntity.ok(response); // ✅ 200 not 201!
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCourseResponse> getCourseById(
            @PathVariable Long id) {
        CreateCourseResponse response = courseService.getCourseById(id); // ✅
        return ResponseEntity.ok(response);
    }
}




//        ## The Pattern To Always Remember:
//        ```
//Controller method ALWAYS:
//        1. calls the service         ← never create empty responses!
//        2. returns what service gave ← wrap in ResponseEntity
//3. POST → 201 CREATED
//4. GET  → 200 OK (ResponseEntity.ok())
//        5. GET requests → NO @RequestBody!