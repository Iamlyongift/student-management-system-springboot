package com.student.management.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseResponse {

    private Long id;
    private String title;
    private String courseCode;
    private Integer creditUnits;
    private String description;
}
