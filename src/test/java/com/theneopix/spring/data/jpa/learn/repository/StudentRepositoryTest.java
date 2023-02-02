package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest we need to use this for testing repository so that database will not be reflected. But for now we want database to reflect so we are using SpringBootTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("kkbist@gmail.com")
                .firstName("KK")
                .lastName("Bist")
                .guardianName("TheNeoPix")
                .guardianEmail("theneopix@gmail.com")
                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List: "+ studentList    );
    }
}