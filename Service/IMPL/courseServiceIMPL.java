package com.example.demo.Service.IMPL;

import com.example.demo.DTO.RequestDTO.RequestStudentDTO;
import com.example.demo.DTO.ResponseDTO.ResponseStudentDTO;
import com.example.demo.ENTITY.Student;
import com.example.demo.Repo.StudentRepo;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class courseServiceIMPL implements CourseService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudent(RequestStudentDTO dto) {
        Student student = new Student(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getCourse()
        );

        StudentRepo.saveStudent(student);
        return dto.getFirstName();
    }

    @Override
    public List<ResponseStudentDTO> getStudentsDetails() {
        ArrayList<ResponseStudentDTO> arrayList = new ArrayList<>();

        List<Student> students = studentRepo.findAll();
        for (Student s : students) {
            arrayList.add(
                    new ResponseStudentDTO(
                            s.getFirstName(),
                            s.getLastName(),
                            s.getEmail(),
                            s.getCourse()
                    )
            );
        }

        return arrayList;
    }

    @Override
    public String deleteStudent(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new RuntimeException("Student Doesnt EXIST");

        }
        studentRepo.delete(student.get());
        return student.get().getFirstName();

    }

    @Override
    public String updateStudent(RequestStudentDTO dto, long id) {
      Optional<Student> student = studentRepo.findById(id);
      if (student.isEmpty()){
          throw new RuntimeException("Student Record Updated");
      }
      student.get().setFirstName(dto.getFirstName());
      student.get().setLastName(dto.getLastName());
      student.get().setEmail(dto.getEmail());
      student.get().setCourse(dto.getCourse());

      studentRepo.save(student.get());
        return dto.getFirstName();
    }
}