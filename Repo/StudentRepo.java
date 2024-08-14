package com.example.demo.Repo;

import com.example.demo.ENTITY.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StudentRepo<Student> extends JpaRepository<Student,Long> {
    static void saveStudent(com.example.demo.ENTITY.Student student) {
    }
}
