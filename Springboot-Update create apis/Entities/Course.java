package com.codeline.Springboot.Entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int creditHours;
    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;


    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL)
    private Instructor instructor;

    @OneToMany
    private List<Mark> marks;

    @ManyToOne
   private Department department;
}
