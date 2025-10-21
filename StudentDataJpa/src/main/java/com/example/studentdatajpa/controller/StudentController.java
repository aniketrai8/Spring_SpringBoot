package com.example.studentdatajpa.controller;

import com.example.studentdatajpa.exception.ResourceNotFoundException;
import com.example.studentdatajpa.model.Student;
import com.example.studentdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Tag(name = "Student Management API", description = " Handles all CURD operations and search feature")
@RestController
@RequestMapping("/students")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation (summary= "searchByName", description ="Fetches all the existing student records")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Student by ID", description = "Returns a single student based on its ID")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            Optional<Student> student = studentService.getStudentById(id);
            if (student.isPresent()) {
                return ResponseEntity.ok(student.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try{
            Student updated = studentService.updateStudent(id, student);
            return ResponseEntity.ok(updated);

        }catch(ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student", description = "Deletes a student record by ID")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Deleted");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @GetMapping("/search/name")
    @Operation (summary ="Search by prefix" ,description =" Finds all students with particular prefix")
    public List<Student> searchByName(@RequestParam String prefix) {
        return studentService.findByName(prefix);
    }

    @GetMapping("/search/course")
    @Operation (summary ="Search by Course", description = "Finds all the students that belong to a particular course")
    public List<Student> searchByCourse(@RequestParam String word) {
        return studentService.findByCourse(word);
    }
}
