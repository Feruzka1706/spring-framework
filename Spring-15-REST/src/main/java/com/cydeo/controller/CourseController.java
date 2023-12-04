package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //@Controller + @ResponseBody
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    //@ResponseBody
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }


    @GetMapping("{id}")
    //@ResponseBody
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }



}
