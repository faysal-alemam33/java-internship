package com.springboot.DTO;

import com.springboot.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long id;
    private Long studentId;
    private Long courseId;
    private int rating;
    private String comment;


}
