package com.jalitha.rentcar.demoapplication.controller;

import com.jalitha.rentcar.demoapplication.model.Student;
import com.jalitha.rentcar.demoapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greeting() {
        return "Hello Microservice, From POST";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting2() {
        return "Hello Microservice, From GET";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
        Student student = studentService.fetchStudentById(id);

        if(student == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> fectchAllStudents() {
        return studentService.fetchAllStudents();
    }
}
