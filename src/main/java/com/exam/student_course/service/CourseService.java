package com.exam.student_course.service;

import com.exam.student_course.entity.Course;
import com.exam.student_course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Récupérer tous les cours
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Récupérer un cours par ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Sauvegarder ou mettre à jour un cours
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    // Supprimer un cours
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
