package com.codeline.Springboot.controllers;

import com.codeline.Springboot.entities.Course;
import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.services.CourseService;
import com.codeline.Springboot.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("/createInstructor")
    public Instructor createInstructor(@RequestBody Instructor requestObj){
        Instructor instructor = instructorService.saveInstructor(requestObj);
        return instructor;
    }

    @GetMapping("/getAllInstructor")
    public List<Instructor> getAllInstructor(){
        List<Instructor> instructors= instructorService.getAllInstructor();
        return instructors;
    }

    @GetMapping("/getInstructor/{id}")
    public Instructor getInstructorById(@PathVariable int id) throws Exception{
        return instructorService.getCourseById(id);
    }

    @PutMapping("/updateInstructor")
    public Instructor updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception{
        return instructorService.updateInstructor(updateObjFromUser);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception{
        instructorService.deleteInstructor(id);
        return "Success";
    }
}
