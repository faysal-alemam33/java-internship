package com.springboot.DTO;

import com.springboot.entity.Admin;
import com.springboot.entity.Instructor;
import com.springboot.entity.Student;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String tags;
    private boolean isFree;
    private double price;
    private Admin admin;
    private Instructor instructor;
    private Student student;  // Add this line



}
