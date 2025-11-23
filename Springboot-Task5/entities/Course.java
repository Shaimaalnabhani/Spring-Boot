package com.codeline.Springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int creditHours;
    private String instructorName;
    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;
}
