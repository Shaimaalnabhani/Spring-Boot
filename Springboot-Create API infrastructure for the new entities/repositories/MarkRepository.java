package com.codeline.Springboot.repositories;

import com.codeline.Springboot.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {
}
