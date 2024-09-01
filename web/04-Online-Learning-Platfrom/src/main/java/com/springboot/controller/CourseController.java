package com.springboot.controller;

import com.springboot.DTO.CourseDTO;
import com.springboot.entity.Course;
import com.springboot.entity.User;

import com.springboot.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        try {
            CourseDTO createdCourse = courseService.createCourse(courseDTO);
            return new ResponseEntity<>(createdCourse, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<List<CourseDTO>> getAppendApprovalCourses(@RequestBody User currentuser){
        try{
            List<CourseDTO> pendingCourses = courseService.getAppendApprovalCourses(currentuser);
            return new ResponseEntity<>(pendingCourses, HttpStatus.OK);
        }
        catch (SecurityException e){
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/approve/{courseId}")
    public ResponseEntity<CourseDTO> approveCourse(@PathVariable Long courseId) {
        try {
            Course currentCourse = new Course();
            currentCourse.setId(courseId);

            CourseDTO approvedCourseDTO = courseService.approveCourse(currentCourse);
            return ResponseEntity.ok(approvedCourseDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
