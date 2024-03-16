package com.example.controller;

import com.example.dto.EducationDTO;
import com.example.dto.NewsDTO;
import com.example.mapper.NewsImageMapper;
import com.example.service.EducationService;
import com.example.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mainpage")
public class MainPageController {
    EducationService educationService;
    NewsService newsService;

    @Autowired
    public MainPageController(NewsService newsService,EducationService educationService) {
        this.newsService = newsService;
        this.educationService = educationService;
    }

    @GetMapping("/geteducation")
    private List<EducationDTO> getEducationName() {
        return educationService.GetAllEducation();
    }

    @GetMapping("/getnews")//4 adet rastgele haber çeker
    private List<NewsDTO> getAllNews() {
        return newsService.GetAllNews();
    }
}
