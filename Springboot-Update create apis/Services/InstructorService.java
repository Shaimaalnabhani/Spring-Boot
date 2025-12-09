package com.codeline.Springboot.Services;

import com.codeline.Springboot.Helper.Constants;
import com.codeline.Springboot.Helper.HelperUtils;
import com.codeline.Springboot.RequestObject.InstructorCreateRequest;
import com.codeline.Springboot.Entities.Course;
import com.codeline.Springboot.Entities.Department;
import com.codeline.Springboot.Entities.Instructor;
import com.codeline.Springboot.repositories.CourseRepository;
import com.codeline.Springboot.repositories.DepartmentRepository;
import com.codeline.Springboot.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }


    public Instructor saveInstructor(InstructorCreateRequest request) throws Exception {
        Instructor instructor = InstructorCreateRequest.convertToInstructor(request);
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            instructor.setCourse(course);
        } else {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        Department department = departmentRepository.getDepartmentById(request.getDepartmentId());
        if (HelperUtils.isNotNull(department)) {
            instructor.setDepartment(department);
        } else {
            throw new Exception(Constants.INSTRUCTOR_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }

        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor inst) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(inst.getId()).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            inst.setUpdatedDate(new Date());
            return instructorRepository.save(inst);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteInstructor(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Instructor getCourseById(Integer id) throws Exception{
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            return existingInstructor;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
