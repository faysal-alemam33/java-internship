package com.springboot.service;

import com.springboot.DTO.CourseDTO;
import com.springboot.entity.Course;
import com.springboot.entity.Instructor;
import com.springboot.entity.User;
import com.springboot.enums.Role;
import com.springboot.repository.AdminRepository;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.InstructorReporsitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstructorReporsitory instructorReporsitory;
    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public CourseDTO createCourse(CourseDTO courseDTO){
        Optional<Instructor> instructor = instructorReporsitory.findById(courseDTO.getInstructor().getId());
        if(instructor.isPresent() && instructor.get().getRole() == Role.INSTRUCTOR ){
            Course course = new Course();
            course.setTitle(courseDTO.getTitle());
            course.setDescription(courseDTO.getDescription());
            course.setTags(courseDTO.getTags());
            course.setStatus(courseDTO.getStatus());
            course.setCategory(courseDTO.getCategory());
            course.setFree(courseDTO.isFree());
            course.setInstructor(courseDTO.getInstructor());
            course.setAdmin(courseDTO.getAdmin());
            course.setApproved(false);              // default to not approved
            Course savedCourse = courseRepository.save(course);
            return convertToDTO(savedCourse);
        } else {
            throw new IllegalArgumentException("Invalid instructor ID or user is not an instructor");
        }
    }

    public List<CourseDTO> getAppendApprovalCourses(User user){
        if(user.getRole() == Role.ADMIN || user.getRole() == Role.INSTRUCTOR){
            return courseRepository.findByApproved(false).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            throw new SecurityException("Access denied: Only admins and instructors can view pending approval courses.");
        }
    }

    @Transactional              // this availabilty manage by admin
    public CourseDTO approveCourse(Course currentcourse){
        Optional<Course> course = courseRepository.findById(currentcourse.getId());
        if(course.isPresent()){
            course.get().setApproved(true);
            Course approvedCourse = courseRepository.save(course.get());
            return convertToDTO(approvedCourse);
        } else {
            throw new IllegalArgumentException("Course not Found");
        }
    }
    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setCategory(course.getCategory());
        courseDTO.setTags(course.getTags());
        courseDTO.setFree(course.isFree());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setInstructor(course.getInstructor());
        courseDTO.setApproved(course.isApproved());
        return courseDTO;
    }

}
