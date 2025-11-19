package com.codeline.Springboot.controllers;

import com.codeline.Springboot.entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class HelloController {

    private List<Course> courseList = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping("/courses")
    public String createCourse(@RequestBody Course requestObj){
        requestObj.setId(idCounter);
        requestObj.setCreatedDate(new Date());
        requestObj.setIsActive(true);

        courseList.add(requestObj);

        return "Course created with ID:" + idCounter++;
    }

    /*@GetMapping("fillData")
    public String addSampleData() {
        createCourse("Java");
        createCourse("Radar");
        createCourse("History");
        createCourse("Signals");
        createCourse("Art");
        createCourse("Science");
        createCourse("Arabic");
        return "Completed";
    }*/


    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> activeCourseList = new ArrayList<>();
        for (Course course : courseList){
            if (course.getIsActive()){
                activeCourseList.add(course);
            }
        }
        return activeCourseList;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        for (Course course: courseList){
            if (course.getId()==id && course.getIsActive()){
                return course;
            }
        }
        return Course.builder().build();
    }

    @PutMapping("update")
    public String updateCourse(@RequestBody Course updateObjFromUser) {
        if (updateObjFromUser != null && updateObjFromUser.getId() > 0) {
            Course existingCourseToUpdate = findCourseById(updateObjFromUser.getId());
            courseList.remove(existingCourseToUpdate);
            existingCourseToUpdate.setName(updateObjFromUser.getName());
            existingCourseToUpdate.setCreditHours(updateObjFromUser.getCreditHours());
            existingCourseToUpdate.setInstructorName(updateObjFromUser.getInstructorName());
            existingCourseToUpdate.setUpdatedDate(new Date());

            courseList.add(existingCourseToUpdate);

            return "Course updated successfully";
        }
        return "Course not found";
    }


    @DeleteMapping("/courses/{id}")
   public String deleteCourse(@PathVariable int id){
        Course courseToDelete = findCourseById(id);
       if (courseToDelete.getId()>0){
           courseList.remove(courseToDelete);
           courseToDelete.setIsActive(false);
           courseToDelete.setUpdatedDate(new Date());
            return "Course deleted Successfully";
        }
       return "Course Not found";
   }

    public Course findCourseById(int id) {
        for (Course course : courseList) {
            if (course.getId() == id) {
                return course;
            }
        }
        return Course.builder().id(-1).build();
    }


}
