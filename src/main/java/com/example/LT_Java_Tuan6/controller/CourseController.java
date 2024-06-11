package com.example.LT_Java_Tuan6.controller;


import com.example.LT_Java_Tuan6.model.Course;
import com.example.LT_Java_Tuan6.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("course", courseService.getAllCourse());
        return "/course/home";
    }
    // For adding a new product
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "/course/create";
    }
    // Process the form for adding a new product
    @PostMapping("/add")
    public String addProduct(@Valid Course course, BindingResult result ) {
        if (result.hasErrors()) {
            return "/course/create";
        }
        courseService.addCourse(course);
        return "redirect:/course";
    }


    // For editing a product
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        model.addAttribute("course",course);
        return "/course/edit";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid Course course, BindingResult result ) {
        if (result.hasErrors()) {
            course.setId(id); //
            return "/course/edit";
        }
        courseService.updateCourse(course);
        return "redirect:/course";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        courseService.deleteCourseId(id);
        return "redirect:/course";
    }
}
