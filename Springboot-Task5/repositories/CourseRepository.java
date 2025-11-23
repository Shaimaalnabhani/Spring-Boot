package com.codeline.Springboot.repositories;

import com.codeline.Springboot.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>  {
}
