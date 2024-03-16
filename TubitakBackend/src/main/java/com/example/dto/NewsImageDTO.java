package com.example.dto;

import com.example.entity.News;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NewsImageDTO {
    private int newsimage_id;
    private String newsimage_name;
    private byte[] newsimage_link;
    private News news_id;  // int yaptığın zaman  post atılıyor. News olduğunda get yapılabiliyor.
}
