package com.example.StudentData.controller;

import com.example.StudentData.model.Student;
import com.example.StudentData.service.StudentService;
import com.example.StudentData.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Student} resources.
 * <p>
 * This controller provides CRUD operations for students and also exposes
 * application metadata from {@link AppConfig}.
 * </p>
 *
 * Base path: <b>/students</b>
 *
 * Endpoints include:
 * <ul>
 *     <li>GET /students → Get all students</li>
 *     <li>GET /students/{id} → Get student by ID</li>
 *     <li>POST /students → Create a new student</li>
 *     <li>PUT /students/{id} → Update an existing student</li>
 *     <li>DELETE /students/{id} → Delete a student</li>
 *     <li>GET /students/app-info → Get app metadata</li>
 * </ul>
 *
 * @author An…
 * @version 1.0
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final AppConfig appConfig;

    /**
     * Constructs the {@code StudentController} with required dependencies.
     *
     * @param studentService the service layer for student operations
     * @param appConfig the application configuration provider
     */
    @Autowired
    public StudentController(StudentService studentService, AppConfig appConfig) {
        this.studentService = studentService;
        this.appConfig = appConfig;
    }

    /**
     * Retrieves all students.
     *
     * @return a list of all {@link Student} objects
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id the ID of the student
     * @return an {@link Optional} containing the {@link Student} if found, otherwise empty
     */
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    /**
     * Retrieves application metadata including name, version, and author.
     *
     * @return a formatted {@link String} containing application info
     */
    @GetMapping("/app-info")
    public String getAppInfo() {
        return "App: " + appConfig.getAppName() +
                ", Version: " + appConfig.getAppVersion() +
                ", Author: " + appConfig.getAppAuthor();
    }

    /**
     * Creates a new student record.
     *
     * @param student the {@link Student} object to create
     * @return the created {@link Student} object
     */
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    /**
     * Updates an existing student record.
     *
     * @param id the ID of the student to update
     * @param student the updated {@link Student} data
     * @return an {@link Optional} containing the updated {@link Student} if found, otherwise empty
     */
    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    /**
     * Deletes a student record.
     *
     * @param id the ID of the student to delete
     * @return {@code "Deleted"} if the student was found and removed,
     *         or {@code "Not Found"} if no student with the given ID exists
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id) ? "Deleted" : "Not Found";
    }
}
