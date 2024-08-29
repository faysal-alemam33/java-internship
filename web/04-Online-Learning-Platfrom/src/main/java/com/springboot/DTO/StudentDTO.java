package com.springboot.DTO;

import com.springboot.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;

}
