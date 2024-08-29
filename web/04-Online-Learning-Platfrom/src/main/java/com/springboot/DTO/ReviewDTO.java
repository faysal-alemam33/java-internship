package com.springboot.DTO;

import com.springboot.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {

    private long id;
    private int rating;
    private Student student;


}
