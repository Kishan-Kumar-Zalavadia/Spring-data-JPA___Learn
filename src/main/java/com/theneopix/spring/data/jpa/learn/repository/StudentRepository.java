package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName,String lastName);

    //Document: 
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}
