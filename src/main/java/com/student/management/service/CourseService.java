package com.student.management.service;

import com.student.management.dtos.CreateCourseRequest;
import com.student.management.dtos.CreateCourseResponse;

import java.util.List;

public interface CourseService {
 CreateCourseResponse createCourse(CreateCourseRequest request);
 List<CreateCourseResponse> getAllCourse();
 CreateCourseResponse getCourseById(Long id);
}
