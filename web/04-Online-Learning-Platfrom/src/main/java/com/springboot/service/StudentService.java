package com.springboot.service;

import com.springboot.entity.Course;
import com.springboot.entity.Student;
import com.springboot.repository.CourseRepository;
import com.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public List<Student> getAllStudentsByCourse(Long courseId){
        return studentRepository.findAllById(courseId);
    }
    public Student findStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Studnet(User) Not Found. Login "));
    }

//    public String addStudent(Student student){
//        try {
//            studentRepository.save(student);
//        }catch ()
//    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
    public String enrollInCourse(Long studentId,Long courseId){
           Student student = studentRepository.findById(studentId)
                   .orElseThrow(() -> new IllegalArgumentException("This student is already enrolled in this course"));
           Course course = courseRepository.findById(courseId)
                   .orElseThrow(() -> new IllegalArgumentException("This student is already enrolled in this course"));

          student.getCourses().add(course);
          updateStudent(student);
           return "Congrats, you have Successfully enrolled in this course!";
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public List<Course> findAllCourses(Long studentId){
        Student student = studentRepository.findById(studentId).orElse(null);
        return student.getCourses()
                .stream().collect(Collectors.toList());

    }
    public void deletStudent(Long id){
        studentRepository.deleteById(id);
    }

}
