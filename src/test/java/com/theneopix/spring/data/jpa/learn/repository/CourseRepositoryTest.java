package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Course;
import com.theneopix.spring.data.jpa.learn.entity.Student;
import com.theneopix.spring.data.jpa.learn.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: "+courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords)
                .getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("Total elements: "+totalElements);
        System.out.println("Total pages: "+totalPages);
        System.out.println("Courses: "+courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );

        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").
                                descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credits"))
                );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("Courses: "+courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining(
                "D",
                firstPageTenRecords).getContent();

        System.out.println("Courses: "+courses);
    }

    @Test
    public void SaveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Ben")
                .lastName("Stone")
                .build();

        Student student = Student.builder()
                .firstName("Cal")
                .lastName("Stone")
                .emailId("calstone@gmail.com")
                .build();

        Course course = Course.builder()
                .title("Mathematics")
                .credit(2)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}