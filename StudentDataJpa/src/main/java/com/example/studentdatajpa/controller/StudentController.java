package com.example.studentdatajpa.controller;

import com.example.studentdatajpa.model.Student;
import com.example.studentdatajpa.service.StudentService;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotation.Operations;
//import io.swagger.v3.oas.annotation.tags.Tag;

import java.util.List;
import java.util.Optional;

//@Tag(name = "Student Management API", description = " Handles all CURD operations and search feature")
@RestController
@RequestMapping("/students")
//@Tag(name= "Students",description="Endpoints for managing student records")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    //@Operation (summary= "searchByName", description ="Fetches all the existing student records")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    //@Operation (summary = "Get Students by ID" , description = " Returns a single student based on its ID")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    //@Operations(summary ="deleteByID" , description = " Helps to delete student record by id")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id) ? "Deleted" : "Not Found";
    }


    @GetMapping("/search/name")
    //@Operation (summary ="Search by prefix" ,description =" Finds all students with particular prefix")
    public List<Student> searchByName(@RequestParam String prefix) {
        return studentService.findByName(prefix);
    }

    @GetMapping("/search/course")
    //@Operations (summary ="Search by Course", description = "Finds all the students that belong to a particular course")
    public List<Student> searchByCourse(@RequestParam String word) {
        return studentService.findByCourse(word);
    }
}
