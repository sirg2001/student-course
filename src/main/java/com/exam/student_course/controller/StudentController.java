package com.exam.student_course.controller;

import com.exam.student_course.entity.Student;
import com.exam.student_course.entity.Course;
import com.exam.student_course.service.StudentService;
import com.exam.student_course.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Afficher la liste des étudiants
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "students/form";
    }

    // Sauvegarder un étudiant
    @PostMapping
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "students/form";
        }
        
        // Si un cours est sélectionné, on l'associe à l'étudiant
        if (student.getCourse() != null && student.getCourse().getId() != null) {
            Course course = courseService.getCourseById(student.getCourse().getId());
            if (course != null) {
                student.setCourse(course);
            } else {
                result.rejectValue("course", "error.course", "Cours non trouvé");
                model.addAttribute("courses", courseService.getAllCourses());
                return "students/form";
            }
        }
        
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé : " + id));
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        return "students/form";
    }

    // Supprimer un étudiant
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
