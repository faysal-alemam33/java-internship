package com.springboot.repository;

import com.springboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByTitle(String title);
    List<Course> findByInstructorId(Long instructorId);
    List<Course> findByApproved(boolean b);

}
