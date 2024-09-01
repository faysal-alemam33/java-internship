package com.springboot.repository;

import com.springboot.DTO.ReviewDTO;
import com.springboot.entity.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseReviewRepository extends JpaRepository<CourseReview, Long> {

    Optional<Object> findByStudentId(Long studentId);
    List<CourseReview> findByCourseId(Long courseId);

}
