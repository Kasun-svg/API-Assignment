package com.example.demo.DTO.RequestDTO;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String course;


}
