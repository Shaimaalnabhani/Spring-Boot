package com.codeline.Springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
    private Integer obtainedMark;
    private Integer totalMark;

    private Date createdDate;
    private Date UpdatedDate;
    private Boolean isActive;

}
