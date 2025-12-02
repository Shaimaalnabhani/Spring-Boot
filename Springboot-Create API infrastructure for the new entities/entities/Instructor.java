package com.codeline.Springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;
    private String grade;
    private String subject;

    @OneToOne
    @JoinColumn(name="course")
    Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
