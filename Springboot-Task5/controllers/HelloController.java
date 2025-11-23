package com.codeline.Springboot.controllers;

import com.codeline.Springboot.entities.Course;
import com.codeline.Springboot.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class HelloController {
    @Autowired
    CourseService courseService;

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course requestObj){
        Course course = courseService.saveCourse(requestObj);
        return course;
    }


    @GetMapping("/courses")
    public List<Course> getAllCourses(){
    List<Course> courses= courseService.getAllCourses();
    return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) throws Exception{
        return courseService.getCourseById(id);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course updateObjFromUser) throws Exception{
        return courseService.updateCourse(updateObjFromUser);
    }

    @DeleteMapping("/courses/{id}")
   public String deleteCourse(@PathVariable int id) throws Exception{
        courseService.deleteCourse(id);
        return "Success";
   }
}
