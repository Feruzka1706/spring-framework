package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.*;

@Controller
@RequestMapping
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        String subject = "Collections";
        model.addAttribute("subject",subject);

        //create some random studentId (0-1000) and show it in your UI
        int studentId = new Random().nextInt(1000);
        model.addAttribute("studentId",studentId);

        List<Integer> numbers = Arrays.asList(4,5,7,10);
        model.addAttribute("numbers",numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        return "student/welcome";
    }

}
