package com.example.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

//    @GetMapping("/helloworld")
//    String helloworld(Model theModel) {
//
//        theModel.addAttribute("theDate", java.time.LocalDate.now());
//        return "helloworld";
//    }

    @GetMapping("/showForm")
    String showForm(Model model) {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    String processForm(Model model) {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    String letShutDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");

        String result =" YO ! " + name.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    String proccesFormV3(@RequestParam("studentName") String theName , Model model) {

        String result =" YO v3 ! " + theName.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }

}
