package com.codeline.Springboot.repositories;

import com.codeline.Springboot.Entities.Instructor;
import com.codeline.Springboot.RequestObject.InstructorCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.id=:id and i.isActive=true")
    Instructor getInstructorById(Integer id);

    @Query("SELECT COUNT(i) FROM Instructor i WHERE i.isActive=true")
    Integer getCountOfAllInstructor();

}
