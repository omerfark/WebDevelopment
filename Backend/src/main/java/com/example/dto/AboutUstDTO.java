package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class AboutUstDTO {
    private String aboutus_title;
    private String aboutus_content;
    private Timestamp create_date;

}
