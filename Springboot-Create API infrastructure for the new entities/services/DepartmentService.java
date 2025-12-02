package com.codeline.Springboot.services;

import com.codeline.Springboot.entities.Course;
import com.codeline.Springboot.entities.Department;
import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department saveDept(Department dept){
        dept.setCreatedDate(new Date());
        dept.setIsActive(Boolean.TRUE);
        return departmentRepository.save(dept);
    }

    public Department updateDept(Department dept) throws Exception {
        Department existingDept = departmentRepository.findById(dept.getId()).get();
        if (existingDept != null && existingDept.getIsActive()) {
            dept.setUpdatedDate(new Date());
            return departmentRepository.save(dept);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteDept(Integer id) throws Exception {
        Department existingDept = departmentRepository.findById(id).get();
        if (existingDept != null && existingDept.getIsActive()) {
            existingDept.setUpdatedDate(new Date());
            existingDept.setIsActive(Boolean.FALSE);
            departmentRepository.save(existingDept);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Department getDeptById(Integer id) throws Exception {
        Department existingDept = departmentRepository.findById(id).get();
        if (existingDept != null && existingDept.getIsActive()) {
            return existingDept;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
