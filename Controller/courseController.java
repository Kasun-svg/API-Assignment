package com.example.demo.Controller;

import com.example.demo.DTO.RequestDTO.RequestStudentDTO;
import com.example.demo.Service.IMPL.CourseService;
import com.example.demo.UTILL.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/course")
public class courseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    private ResponseEntity<StandardResponse> saveStudent(
            @RequestBody RequestStudentDTO dto
            ){
        return new ResponseEntity<>(new StandardResponse(
                "Student data Saved",
                200,
                courseService.saveStudent(dto)
        ),HttpStatus.OK);
    }

    @GetMapping("/Get_D")
    private ResponseEntity<StandardResponse> getStudentDetails(){
        return new ResponseEntity<>(new StandardResponse(
                "data received",
                200,
                courseService.getStudentsDetails()
        ),HttpStatus.OK);
    }
@DeleteMapping(path = "/delete/{id}")
    private ResponseEntity<StandardResponse> deleteStudent(
            @PathVariable long id
){
        return new ResponseEntity<>(new StandardResponse(
                "StudentRecord Deleted",
                200,
                courseService.deleteStudent(id)
        ),HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    private  ResponseEntity<StandardResponse> updateStudent(
            @RequestBody RequestStudentDTO dto,
            @PathVariable long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Student Record Updated",
                200,
                courseService.updateStudent(dto,id)
        ),HttpStatus.OK);
    }
}
