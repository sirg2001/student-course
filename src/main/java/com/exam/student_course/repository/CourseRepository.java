package com.exam.student_course.repository;

import com.exam.student_course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // On peut ajouter des méthodes personnalisées ici si besoin
}
