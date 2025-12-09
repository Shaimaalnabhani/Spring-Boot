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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;
    private String name;
    private String email;
    private String specialization;

    @OneToOne
    @JoinColumn(name="course")
    Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
