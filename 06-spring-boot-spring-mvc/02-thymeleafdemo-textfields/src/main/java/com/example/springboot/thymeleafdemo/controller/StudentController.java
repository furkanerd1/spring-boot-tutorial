package com.example.springboot.thymeleafdemo.controller;


import com.example.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/inputForm")
    public String inputForm(Model model) {
        // create a student object
        Student theStudent = new Student();
        model.addAttribute("student", theStudent );
        return "inputForm";
    }

    @PostMapping("/showStudent")
    public String showStudent(@ModelAttribute Student student) {
      //logging
        System.out.println("Firstname : "+student.getFirstName() + " Lastname : "+student.getLastName());
        return "showStudent";
    }
}
