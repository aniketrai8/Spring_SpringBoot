package com.example.studentdatajpa.mapper;

import com.example.studentdatajpa.dto.StudentDTO;
import com.example.studentdatajpa.model.Student;


public class StudentMapper {

    public static StudentDTO toDTO(Student student){
        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getCourse(),
            student.getAge()
            );
        }

    public static com.example.studentdatajpa.model.Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());
        return student;
    }

    }

