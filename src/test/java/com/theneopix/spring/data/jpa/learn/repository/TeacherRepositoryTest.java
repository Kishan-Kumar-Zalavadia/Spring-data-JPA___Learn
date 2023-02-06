package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Course;
import com.theneopix.spring.data.jpa.learn.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        /*
        ----Removed @OneToMany in Teacher---so--->error line 36

        Course course1 = Course.builder()
                .title("C Lang")
                .credit(3)
                .build();
        Course course2 = Course.builder()
                .title("CPP Lang")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Sunil")
                .lastName("Sir")
                .courses(List.of(course1,course2))
                .build();

        teacherRepository.save(teacher);
        */
    }
}