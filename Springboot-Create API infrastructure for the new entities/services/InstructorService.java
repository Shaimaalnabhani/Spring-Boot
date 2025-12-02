package com.codeline.Springboot.services;

import com.codeline.Springboot.entities.Course;
import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;


    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }


    public Instructor saveInstructor(Instructor instructor) {
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

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
