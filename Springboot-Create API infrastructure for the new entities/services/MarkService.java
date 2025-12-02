package com.codeline.Springboot.services;

import com.codeline.Springboot.entities.Instructor;
import com.codeline.Springboot.entities.Mark;
import com.codeline.Springboot.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }


    public Mark saveMark(Mark mark) {
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);

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
