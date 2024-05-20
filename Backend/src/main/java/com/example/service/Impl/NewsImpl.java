package com.example.service.Impl;

import com.example.dto.ContactDTO;
import com.example.dto.NewsDTO;
import com.example.entity.News;
import com.example.mapper.ContactFormMapper;
import com.example.mapper.NewsMapper;
import com.example.repository.NewsRepository;
import com.example.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class NewsImpl implements NewsService {

    NewsRepository newsRepository;

    public NewsImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public String CreateNews(NewsDTO newsDTO) {
        News news = NewsMapper.toEntity(newsDTO);
        newsRepository.save(news);
        return "News Created";
    }

    @Override
    public NewsDTO GetByIdNews(int news_id) {
        News news = newsRepository.findById((long) news_id).orElseThrow(() -> new RuntimeException("News id not found"));
        return NewsMapper.toDTO(news);
    }

    @Override
    public List<NewsDTO> GetAllNews() {
        List<News> news = newsRepository.findAll();
        if (news.size() <= 6) {
            return mapDTO(news);
        } else {
            List<News> newsShuffle = new ArrayList<>(news);
            Collections.shuffle(newsShuffle, new Random());
            return mapDTO(newsShuffle.subList(0, 6));
        }
    }
    private List<NewsDTO> mapDTO(List<News> news) {
        List<NewsDTO> dtoList = new ArrayList<>();
        for (News news1 : news) {
            dtoList.add(NewsMapper.toDTO(news1));
        }
        return dtoList;
    }


    @Override
    public String DeleteNews(int news_id) {
        newsRepository.deleteById((long) news_id);
        return "News Delete";
    }
}
