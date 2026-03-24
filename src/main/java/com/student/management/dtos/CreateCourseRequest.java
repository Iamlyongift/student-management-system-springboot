package com.student.management.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCourseRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String  courseCode;

    @NotNull
    private Integer  creditUnits;


    private String description;
}

// required field → needs annotation
//@NotBlank        // for Strings
//@NotNull         // for Integer, Long, Boolean etc