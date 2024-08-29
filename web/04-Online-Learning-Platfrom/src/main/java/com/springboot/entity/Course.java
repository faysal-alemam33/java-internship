package com.springboot.entity;

import com.springboot.DTO.CourseDTO;
import com.springboot.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;

    @Column(unique = true)
    private String category;

    private String tags;

    private boolean isFree;

    private double price;

    @ManyToOne
    @JoinColumn(name = "student_id")  // Add this line
    private Student student;  // Add this line

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @OneToMany(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "course_id")
    private List<Content> contents;

    // admin approval process
    private boolean approved = false;



}
