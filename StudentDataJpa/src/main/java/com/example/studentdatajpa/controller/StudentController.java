package com.example.studentdatajpa.controller;

import com.example.studentdatajpa.model.Student;
import com.example.studentdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/database")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
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
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id) ? "Deleted" : "Not Found";
    }


    @GetMapping("/search/name")
    public List<Student> searchByName(@RequestParam String prefix) {
        return studentService.findByName(prefix);
    }

    @GetMapping("/search/course")
    public List<Student> searchByCourse(@RequestParam String word) {
        return studentService.findByCourse(word);
    }
}
