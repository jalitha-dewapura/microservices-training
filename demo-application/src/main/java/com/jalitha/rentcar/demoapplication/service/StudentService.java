package com.jalitha.rentcar.demoapplication.service;

import com.jalitha.rentcar.demoapplication.model.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student fetchStudentById(int id);

    List<Student> fetchAllStudents();
}
