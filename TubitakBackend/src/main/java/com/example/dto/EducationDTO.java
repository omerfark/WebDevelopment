package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@RequiredArgsConstructor
public class EducationDTO {
    private int education_id;
    private String education_name;
    private String education_educator;
    private Timestamp create_date;
    private String education_content;
}

