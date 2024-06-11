package com.example.LT_Java_Tuan6.service;



import com.example.LT_Java_Tuan6.model.Course;
import com.example.LT_Java_Tuan6.repository.CourseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {
    private  final CourseRepository courseRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    public Course updateCourse(@NotNull Course course) {
        Course existingCourse = courseRepository.findById(course.getId()).orElseThrow(() -> new IllegalStateException("Product with ID " + course.getId() + " does not exist."));
        existingCourse.setTeacherName(course.getTeacherName());
        existingCourse.setPlace(course.getPlace());
        existingCourse.setStartDate(course.getStartDate());
        return courseRepository.save(existingCourse);
    }
    // Delete a product by its id
    public void deleteCourseId(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        courseRepository.deleteById(id);
    }

}

