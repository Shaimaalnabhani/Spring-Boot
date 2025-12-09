package com.codeline.Springboot.repositories;

import com.codeline.Springboot.Entities.Mark;
import com.codeline.Springboot.RequestObject.MarkCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {

    @Query("SELECT m FROM Mark m WHERE m.isActive=true AND m.mark IN (:marks) ")
    List<Mark> getMarkByStudentName(List<MarkCreateRequest> marks);

}
