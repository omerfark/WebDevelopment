package com.example.dto;

import com.example.entity.Education;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EducationStepDTO {
    private int educationstep_id;
    private String educationstep_title;
    private String educationstep_content;
    private byte[] educationstep_image;
    private Education education_id;
}
