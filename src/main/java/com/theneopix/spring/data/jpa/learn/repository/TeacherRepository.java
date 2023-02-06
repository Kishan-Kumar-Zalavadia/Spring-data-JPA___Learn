package com.theneopix.spring.data.jpa.learn.repository;

import com.theneopix.spring.data.jpa.learn.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
