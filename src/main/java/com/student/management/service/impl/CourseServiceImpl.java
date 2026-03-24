package com.student.management.service.impl;


import com.student.management.dtos.CreateCourseRequest;
import com.student.management.dtos.CreateCourseResponse;
import com.student.management.model.Course;
import com.student.management.repository.CourseRepository;
import com.student.management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl  implements CourseService {

private final CourseRepository courseRepository;

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest request) {
        if (courseRepository.findByCourseCode(request.getCourseCode()).isPresent()){
            throw new IllegalArgumentException("courseCode already exists");
        }
        Course course = new Course();

        course.setTitle(request.getTitle());
        course.setCourseCode(request.getCourseCode());
        course.setCreditUnits(request.getCreditUnits());
        course.setDescription(request.getDescription());

        Course newCourse = courseRepository.save(course);

        return new CreateCourseResponse(
                newCourse.getId(),
                newCourse.getTitle(),
                newCourse.getCourseCode(),
                newCourse.getCreditUnits(),
                newCourse.getDescription()
        );
    }

@Override
public List<CreateCourseResponse> getAllCourse() {
    List<Course> courses = courseRepository.findAll();
    List<CreateCourseResponse> responses = new ArrayList<>();
    for (Course course : courses) {
        CreateCourseResponse response = new CreateCourseResponse(
                course.getId(),        // ← from course!
                course.getTitle(),     // ← from course!
                course.getCourseCode(),// ← from course!
                course.getCreditUnits(),// ← from course!
                course.getDescription()// ← from course!
        );
        responses.add(response);
    }
    return responses;
}

    @Override
    public CreateCourseResponse getCourseById(Long id) {
           Course course = courseRepository.findById(id)
                   .orElseThrow(() -> new IllegalArgumentException("course not found") );
        return new CreateCourseResponse(
                course.getId(),
                course.getTitle(),
                course.getCourseCode(),
                course.getCreditUnits(),
                course.getDescription()
        );
    }
}