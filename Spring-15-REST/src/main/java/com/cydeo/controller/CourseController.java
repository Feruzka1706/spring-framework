package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //@Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
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



    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){

        return courseService.getCoursesByCategory(category);
    }


    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
        return courseService.createCourse(courseDTO);
    }


    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO courseDTO){
         courseService.updateCourse(courseId,courseDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }


}
