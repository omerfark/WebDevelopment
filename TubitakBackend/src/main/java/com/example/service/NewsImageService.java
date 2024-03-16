package com.example.service;

import com.example.dto.NewsDTO;
import com.example.dto.NewsImageDTO;
import com.example.entity.NewsImage;

import java.util.List;

public interface NewsImageService {
    public String CreateNewsImage(NewsImageDTO newsImageDTO);
    public NewsImageDTO GetByIdNewsImage(int newsimage_id);

    public List<NewsImageDTO> GetAllNewsImage();
}
