package com.codeline.Springboot.controllers;

import com.codeline.Springboot.entities.Department;
import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.repositories.DepartmentRepository;
import com.codeline.Springboot.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/createDept")
    public Department createDept(@RequestBody Department requestObj){
        Department dept = departmentService.saveDept(requestObj);
        return dept;
    }

    @GetMapping("/getAllDept")
    public List<Department> getAllDept(){
        List<Department> deptList= departmentService.getAllDepartment();
        return deptList;
    }

    @GetMapping("/getDeptById/{id}")
    public Department getDeptById(@PathVariable int id) throws Exception{
        return departmentService.getDeptById(id);
    }

    @PutMapping("/updateDept")
    public Department updateDept(@RequestBody Department updateObjFromUser) throws Exception{
        return departmentService.updateDept(updateObjFromUser);
    }

    @DeleteMapping("/deleteDept/{id}")
    public String deleteDept(@PathVariable int id) throws Exception{
        departmentService.deleteDept(id);
        return "Success";
    }
}
