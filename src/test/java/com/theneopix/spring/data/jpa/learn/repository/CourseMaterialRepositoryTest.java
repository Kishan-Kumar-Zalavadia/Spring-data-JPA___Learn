package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Course;
import com.theneopix.spring.data.jpa.learn.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dotnet.com")
                .course(course)
                .build();
        //If you don't add course(line 30) it will give error because optional=false in CourseMaterial
        repository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("Course Materials: "+ courseMaterials);
    }
}