package com.jalitha.rentcar.demoapplication.service;

import com.jalitha.rentcar.demoapplication.model.Student;
import com.jalitha.rentcar.demoapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student fetchStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        return student.orElse(null);
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

}
