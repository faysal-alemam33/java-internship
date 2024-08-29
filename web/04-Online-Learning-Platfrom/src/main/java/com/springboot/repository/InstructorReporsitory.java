package com.springboot.repository;

import com.springboot.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorReporsitory extends JpaRepository<Instructor, Long> {
    Instructor findByEmail(String email);
    boolean existsByEmail(String email);
}
