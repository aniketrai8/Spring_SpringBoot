package com.example.studentdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class StudEntity {

    @Id
    private Long id;
    private String name;
    private String course;
    private int age;
}
