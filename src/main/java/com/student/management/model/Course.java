package com.student.management.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private Integer creditUnits;

    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    private List<Student> students;

}
