package com.example.studentdata.service;

import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;


@Service
public class StudentService {
    //private final List<Student> students = new ArrayList<>();
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents() {

        return repository.findAll(); //select * from students
    }

    public Optional<Student> getStudentById(Long id) {

        return repository.findById(id); //select row by ID
    }

    public Student addStudent(Student student) {

        return repository.save(student); //inset/update a row
    }

    public Optional<Student> updateStudent(Long id, Student updated) {
        return repository.findById(id).map(student -> {
            student.setName(updated.getName());
            student.setAge(updated.getAge());
            student.setCourse(updated.getCourse());
            return repository.save(student);
        });


    }

    public boolean deleteStudent(Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}
