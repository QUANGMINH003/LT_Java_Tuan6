package com.example.LT_Java_Tuan6.repository;

import com.example.LT_Java_Tuan6.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
