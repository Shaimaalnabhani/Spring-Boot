package com.codeline.Springboot.ResponseObject;

import com.codeline.Springboot.Entities.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkCreateResponse {
    private int id;
    private String studentName;
    private Double score;
    private Integer courseId;
    private Integer instructorId;


    public static MarkCreateResponse convertToMark(Mark entity) {
        MarkCreateResponse response = MarkCreateResponse.builder()
                .id(entity.getId())
                .studentName(entity.getStudentName())
                .score(entity.getScore())
                .courseId(entity.getCourse().getId())
                .instructorId(entity.getInstructor().getId())
                .build();
        return response;
    }

}
