package com.codeline.Springboot.controllers;

import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.entities.Mark;
import com.codeline.Springboot.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping("/create")
    public Mark createMark(@RequestBody Mark requestObj){
        Mark mark = markService.saveMark(requestObj);
        return mark;
    }

    @GetMapping("/getAll")
    public List<Mark> getAllMark(){
        List<Mark> marks= markService.getAllMark();
        return marks;
    }

    @GetMapping("/getById/{id}")
    public Mark getMarkById(@PathVariable int id) throws Exception{
        return markService.getMarkById(id);
    }

    @PutMapping("/update")
    public Mark updateMark(@RequestBody Mark updateObjFromUser) throws Exception{
        return markService.updateMark(updateObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMark(@PathVariable int id) throws Exception{
            markService.deleteMark(id);
             return "Success";
    }
}
