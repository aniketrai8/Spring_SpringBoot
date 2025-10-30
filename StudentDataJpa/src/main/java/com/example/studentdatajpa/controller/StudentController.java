package com.example.studentdatajpa.controller;

import com.example.studentdatajpa.dto.StudentDTO;
import com.example.studentdatajpa.exception.ResourceNotFoundException;
import com.example.studentdatajpa.mapper.StudentMapper;
import com.example.studentdatajpa.model.Student;
import com.example.studentdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Tag(name = "Student Management API", description = "Handles all CRUD operations and search features")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    @Operation(summary = "Fetch all students", description = "Fetches all existing student records")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get Student by ID", description = "Returns a single student based on ID")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            Optional<Student> student = studentService.getStudentById(id);
            if (student.isPresent()) {
                return ResponseEntity.ok(StudentMapper.toDTO(student.get()));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Student with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping
    @Operation(summary = "Add new Student", description = "Creates a new student record")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        Student saved = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.toDTO(saved));
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update Student", description = "Updates an existing student record")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        try {
            Student updatedStudent = StudentMapper.toEntity(dto);
            Student updated = studentService.updateStudent(id, updatedStudent);
            return ResponseEntity.ok(StudentMapper.toDTO(updated));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student", description = "Deletes a student record by ID")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/search/name")
    @Operation(summary = "Search by prefix", description = "Finds all students whose name starts with the given prefix")
    public List<StudentDTO> searchByName(@RequestParam String prefix) {
        return studentService.findByName(prefix).stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/search/course")
    @Operation(summary = "Search by course", description = "Finds all students enrolled in a particular course")
    public List<StudentDTO> searchByCourse(@RequestParam String word) {
        return studentService.findByCourse(word).stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
