package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2") //creating versioning of API end points
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    //@ResponseBody
    public ResponseEntity<List<CourseDTO>> getAllCourses(){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses());
    }



    @GetMapping("{id}")
    //@ResponseBody
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseId){

        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PostMapping
    //@ResponseBody
    public ResponseEntity<CourseDTO> createNewCourse(@RequestBody CourseDTO courseDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(courseDTO));
    }

}
