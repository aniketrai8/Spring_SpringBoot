package com.example.studentdatajpa.repository;
import com.example.studentdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByNameStartingWithIgnoreCase(String prefix);
    List<Student> findByCourseContainingIgnoreCase(String word);


}