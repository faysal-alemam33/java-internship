package com.springboot.controller;

import com.springboot.DTO.ReviewDTO;
import com.springboot.service.CourseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class CourseReviewController {


    @Autowired
    private CourseReviewService courseReviewService;

    // Endpoint to create a new course review
    @PostMapping
    public ResponseEntity<ReviewDTO> createCourseReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            ReviewDTO createdReview = courseReviewService.createCourseReview(reviewDTO);
            return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to get reviews by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByCourse(@PathVariable Long courseId) {
        List<ReviewDTO> reviews = courseReviewService.getReviewsByCourse(courseId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Endpoint to get reviews by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByStudent(@PathVariable Long studentId) {
        List<ReviewDTO> reviews = courseReviewService.getReviewsByStudent(studentId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

}
