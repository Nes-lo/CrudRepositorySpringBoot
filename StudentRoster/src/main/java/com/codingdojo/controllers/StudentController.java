package com.codingdojo.controllers;

import com.codingdojo.models.Student;
import com.codingdojo.services.BedroomService;
import com.codingdojo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private BedroomService bedroomService;


    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("bedrooms", bedroomService.allBedrooms());
        return "newStudent.jsp";
    }

    @PostMapping("/students/new")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {

        if(result.hasErrors()) {

            return "newStudent.jsp";
        }
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/remove/{id}")
    public String removeStudent(@PathVariable("id") Long id) {
        studentService.removeFromBedroom(studentService.findStudent(id));
        return "redirect:/";
    }
}
