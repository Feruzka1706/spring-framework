package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {


    @GetMapping("/user")
    public String userInfo(){
        return "/user/userinfo.html"; //go to static folder and look the html file based on given path
    }
}
