package com.student.management.service.impl;

import com.student.management.dtos.CreateStudentRequest;
import com.student.management.dtos.CreateStudentResponse;
import com.student.management.model.Course;
import com.student.management.model.Student;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public CreateStudentResponse createStudent(CreateStudentRequest request) {
        // Step 1: check email
        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use!");
        }

        // Step 2: build student object
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudentClass(request.getStudentClass());
        student.setAge(request.getAge());

        // Step 3: save to database
        Student savedStudent = studentRepository.save(student);

        // Step 4: return response
        return new CreateStudentResponse(
                savedStudent.getId(),
                savedStudent.getFirstName(),
                savedStudent.getLastName(),
                savedStudent.getEmail(),
                savedStudent.getStudentClass(),
                savedStudent.getAge()
        );
    }

    @Override
    public List<CreateStudentResponse> getAllStudents() {
        // Step 1 - get all students
        List<Student> students = studentRepository.findAll();
        // Step 2 - create empty response list
        List<CreateStudentResponse> responses = new ArrayList<>();
        // Step 3 - loop through students
        for (Student student : students) {
            // convert each student to a response
            CreateStudentResponse createStudentResponse = new CreateStudentResponse(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getStudentClass(),
                    student.getAge()
            );
            responses.add(createStudentResponse);
        }
        return responses;
    }

    @Override
    public CreateStudentResponse getStudentById(Long id) {
        // find student OR throw error if not found
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));

        // convert and return
        return new CreateStudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getStudentClass(),
                student.getAge()
        );
    }

    @Override
    public CreateStudentResponse updateStudent(Long id, CreateStudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudentClass(request.getStudentClass());
        student.setAge(request.getAge());

        student = studentRepository.save(student);

        return new CreateStudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getStudentClass(),
                student.getAge()
        );
    }

    @Override
    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));
        studentRepository.delete(student);
        return "Student deleted successfully!";
    }

    @Override
    public String enrollStudentInCourse(Long studentId, Long courseId) {
        //find student by Id
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));
        //find course by Id
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found!"));

        // Step 3: check if already enrolled
        if (student.getCourses().contains(course)) {
            throw new IllegalArgumentException("Course already enrolled!");
        }
        //Add cousre to student list(owner side)
        student.getCourses().add(course);
        //save
        courseRepository.save(course);
        // return message
        return "Student enrolled successfully!";
    }
}
