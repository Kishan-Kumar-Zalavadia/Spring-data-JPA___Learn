package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Guardian;
import com.theneopix.spring.data.jpa.learn.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
//                .guardianName("TheNeoPix")
//                .guardianEmail("theneopix@gmail.com")
//                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails(){

        Guardian guardian = Guardian.builder()
                .name("TheNeoPix2")
                .email("theneopix2@email.com")
                .mobile("0321654987")
                .build();

        Student student = Student.builder()
                .firstName("KK2")
                .lastName("Bist2")
                .emailId("kkbist2@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List: "+ studentList    );
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("KK2");
        System.out.println("Student by firstName: "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("KK");
        System.out.println("Student by firstName Containing: "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("TheNeoPix");
        System.out.println("Student based on guardian name: "+ students);
    }

    //Query test
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("kkbist@gmail.com");
        System.out.println("Student by email address - query: "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("kkbist@gmail.com");
        System.out.println("Student firstName by email address - query: "+studentFirstName);
    }

    //Native Query test
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("kkbist@gmail.com");
        System.out.println("Student by email address - native query: "+student);
    }

    //Native Named Param Query test
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("kkbist@gmail.com");
        System.out.println("Student by email address - native named param query: "+student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("KK","kkbist@gmail.com");
    }
}