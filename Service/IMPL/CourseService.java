package com.example.demo.Service.IMPL;

import com.example.demo.DTO.RequestDTO.RequestStudentDTO;
import com.example.demo.DTO.ResponseDTO.ResponseStudentDTO;

import java.util.List;

public interface CourseService {

    String saveStudent(RequestStudentDTO dto);

    List<ResponseStudentDTO> getStudentsDetails();

    String deleteStudent(long id);

    String updateStudent(RequestStudentDTO dto, long id);
}
