package com.codeline.Springboot.Services;

import com.codeline.Springboot.Helper.Constants;
import com.codeline.Springboot.Helper.HelperUtils;
import com.codeline.Springboot.RequestObject.MarkCreateRequest;
import com.codeline.Springboot.Entities.Course;
import com.codeline.Springboot.Entities.Instructor;
import com.codeline.Springboot.Entities.Mark;
import com.codeline.Springboot.repositories.CourseRepository;
import com.codeline.Springboot.repositories.InstructorRepository;
import com.codeline.Springboot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }


    public Mark saveMark(MarkCreateRequest request) throws  Exception{
        Mark mark = MarkCreateRequest.convertToMark(request);
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            mark.setCourse(course);
        } else {
            throw new Exception(Constants.MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)) {
            mark.setInstructor(instructor);
        } else {
            throw new Exception(Constants.MARK_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        return markRepository.save(mark);
    }

    public Mark updateMark(Mark mark) throws Exception {
        Mark existingMark = markRepository.findById(mark.getId()).get();
        if (existingMark != null && existingMark.getIsActive()) {
            mark.setUpdatedDate(new Date());
            return markRepository.save(mark);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
    public void deleteMark(Integer id) throws Exception {
        Mark existingInstructor = markRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            markRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }

    public Mark getMarkById(Integer id) throws Exception{
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            return existingMark;
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
