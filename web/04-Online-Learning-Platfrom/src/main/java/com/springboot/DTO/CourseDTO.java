package com.springboot.DTO;

import com.springboot.entity.Admin;
import com.springboot.entity.Instructor;
import com.springboot.entity.Student;
import com.springboot.enums.CourseStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String tags;
    private boolean isFree;
    private double price;
    private Student student;  // To link to the student
    private Instructor instructor;  // To link to the instructor
    private Admin admin;  // To link to the admin
    private CourseStatus status;
    private List<ContnetDTO> contents;
    private boolean approved;


}
