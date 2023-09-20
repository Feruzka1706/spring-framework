package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/register")
    public String studentRegister(Model model){

        model.addAttribute("students", DataGenerator.createStudents());

        return "student/register";
    }

    @GetMapping("/welcome")
    public String studentWelcome( Model model){

        model.addAttribute("students", DataGenerator.createStudents());
        return "student/welcome";
    }
}
