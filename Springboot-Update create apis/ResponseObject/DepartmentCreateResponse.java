package com.codeline.Springboot.ResponseObject;

import com.codeline.Springboot.Entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateResponse {

    private Integer id;
    private String name;
    private String description;
    private Integer instructorId;
    private String instructorName;

    public static DepartmentCreateResponse convertToDepartment(Department entity) {
        DepartmentCreateResponse response = DepartmentCreateResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .instructorId(entity.getInstructor().getId())
                .instructorName(entity.getInstructor().getName())
                .build();
        return response;
    }

}
