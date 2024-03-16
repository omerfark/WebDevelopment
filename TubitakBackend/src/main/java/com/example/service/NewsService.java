package com.example.service;

import com.example.dto.NewsDTO;
import com.example.dto.NewsImageDTO;

import java.util.List;

public interface NewsService {
        public String CreateNews(NewsDTO newsDTO);
        public NewsDTO GetByIdNews(int news_id);
        public List<NewsDTO> GetAllNews();
        public String DeleteNews(int news_id);
}
