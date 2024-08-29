package com.springboot.service;

import com.springboot.DTO.UserDTO;
import com.springboot.entity.Admin;
import com.springboot.entity.Instructor;
import com.springboot.entity.Student;
import com.springboot.entity.User;
import com.springboot.enums.Role;
import com.springboot.repository.AdminRepository;
import com.springboot.repository.InstructorReporsitory;
import com.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private InstructorReporsitory instructorReporsitory;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transient
    public User registerUser(UserDTO userDTO){
        if(emailExists(userDTO.getEmail())){
            throw new IllegalArgumentException("Email already in use");
        }
        User user;
        Role role = Role.valueOf(userDTO.getRole().toUpperCase());
        switch (role){
            case STUDENT:
                user = new Student();
                break;
            case INSTRUCTOR:
                user = new Instructor();
                break;
            case ADMIN:
                user = new Admin();
                break;
            default:
                throw new IllegalArgumentException("Invalid Role");
        }

        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        saveUser(user, role);
        emailService.sendVerificationEmail(user.getEmail());

        return user;
    }
    public User loginUser(String email, String password){
        Optional<? extends User> userOptional = findByEmail(email);
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("Invalid credentials or Incorrect password");
        }

        return user;
    }

        public Optional<User> findByEmail(String email){
            Optional<Student> student = studentRepository.findByEmail(email);
            if (student.isPresent()) {
                return Optional.of(student.get());
            }

            Optional<Instructor> instructor = Optional.ofNullable(instructorReporsitory.findByEmail(email));
            if (instructor.isPresent()) {
                return Optional.of(instructor.get());
            }

            Optional<Admin> admin = adminRepository.findByEmail(email);
            if (admin.isPresent()) {
                return Optional.of(admin.get());
            }

            return Optional.empty();
        }

    private boolean emailExists(String email) {
        return studentRepository.existsByEmail(email) ||
                instructorReporsitory.existsByEmail(email) ||
                adminRepository.existsByEmail(email);
    }

    private void saveUser(User user, Role role){
        switch (role){
            case STUDENT :
                studentRepository.save((Student) user);
                break;
            case ADMIN:
                adminRepository.save((Admin) user);
                break;
            case INSTRUCTOR:
                instructorReporsitory.save((Instructor) user);
                break;
        }
    }

}
