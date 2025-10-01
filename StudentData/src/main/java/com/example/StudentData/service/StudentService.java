package com.example.StudentData.service;

import com.example.StudentData.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Optional<Student> updateStudent(Long id, Student updated) {
        return getStudentById(id).map(student -> {
            student.setName(updated.getName());
            student.setAge(updated.getAge());
            student.setCourse(updated.getCourse());
            return student;
        });
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}
