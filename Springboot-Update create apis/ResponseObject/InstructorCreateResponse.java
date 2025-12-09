package com.codeline.Springboot.ResponseObject;

import com.codeline.Springboot.Entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorCreateResponse {
    private int id;
    private String name;
    private String email;
    private String specialization;

    private Integer departmentId;
    private String departmentName;

    private Integer courseId;
    private String courseName;

    public static InstructorCreateResponse convertToInstructor(Instructor entity) {
        InstructorCreateResponse response = InstructorCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .specialization(entity.getSpecialization())
                .departmentId(entity.getDepartment().getId())
                .departmentName(entity.getDepartment().getName())
                .courseId(entity.getCourse().getId())
                .courseName(entity.getCourse().getName())
                .build();
        return response;
    }
}
