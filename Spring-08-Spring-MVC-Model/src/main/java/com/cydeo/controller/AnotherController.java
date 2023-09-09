package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {

    @GetMapping("/list") //localhost:8080/another/list
    public String getAllMentors(Model model){
        List<Mentor> mentors = Arrays.asList(
                new Mentor("Mike","Smith",45, Gender.MALE),
                new Mentor("Tom","Hanks",65, Gender.MALE),
                new Mentor("Ammy","Bryan",25, Gender.FEMALE)
        );
        model.addAttribute("mentors",mentors);
        return "mentor/mentor";
    }
}
