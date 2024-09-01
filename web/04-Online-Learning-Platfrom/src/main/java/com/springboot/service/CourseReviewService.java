package com.springboot.service;

import com.springboot.DTO.ReviewDTO;
import com.springboot.entity.Course;
import com.springboot.entity.CourseReview;
import com.springboot.entity.Student;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.CourseReviewRepository;
import com.springboot.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseReviewService {


    @Autowired
    private CourseReviewRepository courseReviewRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public ReviewDTO createCourseReview(ReviewDTO courseReviewDTO) {
        Optional<Student> student = studentRepository.findById(courseReviewDTO.getStudentId());
        Optional<Course> course = courseRepository.findById(courseReviewDTO.getCourseId());

        if (student.isPresent() && course.isPresent()) {
            CourseReview courseReview = new CourseReview();
            courseReview.setStudent(student.get());
            courseReview.setCourse(course.get());
            courseReview.setRating(courseReviewDTO.getRating());
            courseReview.setComment(courseReviewDTO.getComment());

            CourseReview savedCourseReview = courseReviewRepository.save(courseReview);
            return convertToDTO(savedCourseReview);
        } else {
            throw new IllegalArgumentException("Invalid student ID or course ID");
        }
    }


    public List<ReviewDTO> getReviewsByCourse(Long courseId) {
        return courseReviewRepository.findByCourseId(courseId).stream()
                .map(review -> convertToDTO((CourseReview) review))
                .collect(Collectors.toList());
    }
    public List<ReviewDTO> getReviewsByStudent(Long studentId) {
        return courseReviewRepository.findByStudentId(studentId).stream()
                .map(review -> convertToDTO((CourseReview) review))
                .collect(Collectors.toList());
    }
    private ReviewDTO convertToDTO(CourseReview courseReview) {
        ReviewDTO courseReviewDTO = new ReviewDTO();
        courseReviewDTO.setId(courseReview.getId());
        courseReviewDTO.setStudentId(courseReview.getStudent().getId());
        courseReviewDTO.setCourseId(courseReview.getCourse().getId());
        courseReviewDTO.setRating(courseReview.getRating());
        courseReviewDTO.setComment(courseReview.getComment());
        return courseReviewDTO;
    }

    private CourseReview convertToEntity(ReviewDTO courseReviewDTO) {
        CourseReview courseReview = new CourseReview();
        courseReview.setRating(courseReviewDTO.getRating());
        courseReview.setComment(courseReviewDTO.getComment());

        // Fetching student and course entities should be handled outside this method
        return courseReview;
    }
}
