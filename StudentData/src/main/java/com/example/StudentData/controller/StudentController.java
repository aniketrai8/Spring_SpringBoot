package com.example.StudentData.controller;
import com.example.StudentData.model.Student;
import com.example.StudentData.service.StudentService;
import com.example.StudentData.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final StudentService studentService;
    private final AppConfig appConfig;


    // Constructor Injection (best practice)
    @Autowired
    public StudentController(StudentService studentService, AppConfig appConfig) {
        
        this.studentService = studentService;
        this.appConfig= appConfig;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/app-info")
    public String getAppInfo(){
        return "App: " + appConfig.getAppName()+
                ", Version: " + appConfig.getAppVersion()+
                ", Author: " +appConfig.getAppAuthor();

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

}
