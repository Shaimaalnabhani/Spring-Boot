package com.codeline.Springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello(){
//        return "hello";
//    }

    //1
    @GetMapping("/hello")
    public String name(@RequestParam String name){
        if (name == null || name.isEmpty()){
            return "Hello Guest";
        }
        else {
            return "Hello "+name;
        }
    }


    //2
    @GetMapping("/sum")
    public int sum(@RequestParam int a ,@RequestParam int b){
        return a+b;
    }

    //3
    @GetMapping("/info")
    public Info getInfo(){
    return new Info("Shaima","Nizwa","Arabic");
    }

    //4
    @GetMapping("/greet")
    public String greeting(@RequestParam String name){
        return "Hello "+name;
    }

    //5
    @GetMapping("/upper")
    public String uppercase(@RequestParam String text){
        return text.toUpperCase();
    }

    //6
    @GetMapping("/random")
    public int random(){
        return (int) Math.random() * 100 + 1;
    }

}
