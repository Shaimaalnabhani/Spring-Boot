package com.codeline.Springboot.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    private String studentName;
    private Double score;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;

    @OneToMany
    private Instructor instructor;

    @OneToMany
    private Course course;


}
