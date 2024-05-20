package com.example.controller;

import com.example.dto.NewsDTO;
import com.example.dto.NewsImageDTO;
import com.example.dto.SocialMediaDTO;
import com.example.entity.News;
import com.example.entity.NewsImage;
import com.example.service.NewsImageService;
import com.example.service.NewsService;
import com.example.service.SocialMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsPageController {

    NewsService newsService;
    NewsImageService newsImageService;

    SocialMediaService socialMediaService;

    @Autowired
    public NewsPageController(NewsService newsService, NewsImageService newsImageService, SocialMediaService socialMediaService) {
        this.newsService = newsService;
        this.newsImageService = newsImageService;
        this.socialMediaService = socialMediaService;
    }

    //News bölümü
    @GetMapping("/getall")//Tüm haber listelerini çeker
    private List<NewsDTO> getAllNews() {
        return newsService.GetAllNews();
    }

    @GetMapping("/get/{news_id}") //Seçili haberleri çeker
    private NewsDTO getNews( @PathVariable  int news_id) {
        return newsService.GetByIdNews(news_id);
    }

    @PostMapping("/post")//database e yeni haberler ekler.
    private void createNews(@RequestBody NewsDTO newsDTO) {
        newsService.CreateNews(newsDTO);
    }

    @DeleteMapping("/delete")
    private void deleteNews(int news_id) {
        newsService.DeleteNews(news_id);
    }
    //news Image bölümü
    @PostMapping("/postimage")
    private void createNewsImage(@RequestBody NewsImageDTO newsImageDTO){
        newsImageService.CreateNewsImage(newsImageDTO);
    }
    @GetMapping("/getimage")
    private NewsImageDTO getImage(int newsimage_id){
        return newsImageService.GetByIdNewsImage(newsimage_id);
    }

    @GetMapping("/getallimage")
    private List<NewsImageDTO> getAllImage(){return newsImageService.GetAllNewsImage();}

    @GetMapping("/socialmedia")
    private List<SocialMediaDTO> getAllSocialmedia(){
        return socialMediaService.GetAllSocialMedia();
    }


}
