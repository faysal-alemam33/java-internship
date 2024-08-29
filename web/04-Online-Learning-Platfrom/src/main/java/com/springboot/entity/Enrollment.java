//package com.springboot.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//public class Enrollment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Student_id")
//    private Student student;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    private boolean completed;
//
//}
