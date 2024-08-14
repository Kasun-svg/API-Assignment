package com.example.demo.DTO.ResponseDTO;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudentDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String course;


    public ResponseStudentDTO(String firstName, String lastName, String email, String course) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.course=course;
    }
}
