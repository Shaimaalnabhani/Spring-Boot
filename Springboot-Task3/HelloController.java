package com.codeline.Springboot;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello(){
//        return "hello";
//    }
    private HashMap<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;
 /*   //1
//    @GetMapping("/hello")
//    public String name(@RequestParam String name){
//        if (name == null || name.isEmpty()){
//            return "Hello Guest";
//        }
//        else {
//            return "Hello "+name;
//        }
//    }
//    //2
//    @GetMapping("/sum")
//    public int sum(@RequestParam int a ,@RequestParam int b){
//        return a+b;
//    }
//    //3
//    @GetMapping("/info")
//    public Info getInfo(){
//    return new Info("Shaima","Nizwa","Arabic");
//    }
//
//    //4
//    @GetMapping("/greet")
//    public String greeting(@RequestParam String name){
//        return "Hello "+name;
//    }
//
//    //5
//    @GetMapping("/upper")
//    public String uppercase(@RequestParam String text){
//        return text.toUpperCase();
//    }
//    //6
//    @GetMapping("/random")
//    public int random(){
//        return (int) Math.random() * 100 + 1;
//    }
*/

    @PostMapping("/courses")
    public String createCourse(@RequestParam String name){
        courses.put(idCounter,name);
        return "Course created with ID:" + idCounter++;
    }

    @GetMapping("fillData")
    public String addSampleData() {
        createCourse("Java");
        createCourse("Radar");
        createCourse("History");
        createCourse("Signals");
        createCourse("Art");
        createCourse("Science");
        createCourse("Arabic");
        return "Completed";
    }


    @GetMapping("/courses")
    public HashMap<Integer, String> getAllCourses(){
        return courses;
    }

    @GetMapping("/courses/{id}")
    public String getCourseById(@PathVariable int id){
        return courses.getOrDefault(id,"Course not found");
    }

    @PutMapping("/courses/{id}&{name}")
   public String updateCourse(@PathVariable int id ,@PathVariable String name){
        if (courses.containsKey(id)){
            courses.put(id,name);
            return "Course updated successfully";
        }
       return "Course Not found";
   }

    @DeleteMapping("/courses/{id}")
   public String deleteCourse(@PathVariable int id){
        if (courses.remove(id) != null){
            return "Course deleted Successfully";
        }
       return "Course Not found";
   }
}
