package com.example.controller;

import com.example.dto.NewsDTO;
import com.example.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("newscontent")
public class NewsContentPageController {
    NewsService newsService;
    @Autowired
    public NewsContentPageController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/get")//Seçili haberi çeker
    private NewsDTO getNewsDetails(int news_id) {
        return newsService.GetByIdNews(news_id);
    }
}
