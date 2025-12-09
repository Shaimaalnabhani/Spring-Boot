package com.codeline.Springboot.Services;

import com.codeline.Springboot.Helper.Constants;
import com.codeline.Springboot.Helper.HelperUtils;
import com.codeline.Springboot.RequestObject.CourseCreateRequest;
import com.codeline.Springboot.Entities.Course;
import com.codeline.Springboot.Entities.Department;
import com.codeline.Springboot.Entities.Instructor;
import com.codeline.Springboot.Entities.Mark;
import com.codeline.Springboot.repositories.CourseRepository;
import com.codeline.Springboot.repositories.DepartmentRepository;
import com.codeline.Springboot.repositories.InstructorRepository;
import com.codeline.Springboot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MarkRepository markRepository;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(CourseCreateRequest request) throws Exception {
        Course course=CourseCreateRequest.convertToCourse(request);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)){
            course.setInstructor(instructor);
        } else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        Department department = departmentRepository.getDepartmentById(request.getDepartmentId());
        if (HelperUtils.isNotNull(department)){
            course.setDepartment(department);
        } else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }

        List<Mark> marks= markRepository.getMarkByStudentName(request.getMarks());
        if(HelperUtils.isNotNull(marks)&& HelperUtils.isListNotEmpty(marks)){
        course.setMarks(marks);
        }else{
            throw new  Exception(Constants.COURSE_CREATE_REQUEST_MARK_NOT_VALID);
        }
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();
        if (existingCourse!=null && existingCourse.getIsActive()) {
            course.setUpdatedDate(new Date());
            return courseRepository.save(course);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdatedDate(new Date());
            existingCourse.setIsActive(Boolean.FALSE);
            courseRepository.save(existingCourse);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Course getCourseById(Integer id) throws Exception{
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()){
            return existingCourse;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

}
