package com.example.studentdatajpa.repository;
import com.example.studentdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //@Query(SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT (:prefix,'%'))")
    List<Student> findByNameStartingWithIgnoreCase(String prefix);
    //@Query( SELECT s FROM STUDENT s WHERE LOWER(s.course) LIKE LOWER (CONCAT('%':word,'%'))")
    List<Student> findByCourseContainingIgnoreCase(String word);


}