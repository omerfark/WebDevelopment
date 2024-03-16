package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class NewsDTO {
    private int news_id;
    private String news_title;
    private String news_content;
    private Timestamp create_date;
    private String news_educator;
}
