package com.exam.student_course.repository;

import com.exam.student_course.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Exemples de méthodes custom :
    // List<Student> findByCourseId(Long courseId);
}
