package com.exam.student_course.controller;

import com.exam.student_course.entity.Course;
import com.exam.student_course.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Afficher la liste des cours
    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form";
    }

    // Sauvegarder un cours
    @PostMapping
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            throw new IllegalArgumentException("Cours non trouvé : " + id);
        }
        model.addAttribute("course", course);
        return "courses/form";
    }

    // Supprimer un cours
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
