package com.jalitha.rentcar.demoapplication.repository;

import com.jalitha.rentcar.demoapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student save(Student student);
    //it is required if you use Repository interface to extends
}
