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
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Integer number;
    private String countryCode;
    private Boolean isLandLine;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;


    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

}
