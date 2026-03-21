package com.student.management.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentClass;
    private Integer age;
}
