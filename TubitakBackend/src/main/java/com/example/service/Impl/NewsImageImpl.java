package com.example.service.Impl;

import com.example.dto.NewsImageDTO;
import com.example.entity.News;
import com.example.entity.NewsImage;
import com.example.mapper.NewsImageMapper;
import com.example.repository.NewsImageRepository;
import com.example.service.NewsImageService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsImageImpl implements NewsImageService {

    NewsImageRepository newsImageRepository;


    public NewsImageImpl(NewsImageRepository newsImageRepository) {
        this.newsImageRepository = newsImageRepository;

    }

    @Override
    public String CreateNewsImage(NewsImageDTO newsImageDTO) {
        NewsImage newsImage = NewsImageMapper.toEntity(newsImageDTO);
        newsImageRepository.save(newsImage);
        return "Image create";
    }

    @Override
    public NewsImageDTO GetByIdNewsImage(int newsimage_id) {
        NewsImage newsImage = newsImageRepository.findById((long) newsimage_id).orElseThrow(()->new RuntimeException("Newss image not found"));
        return NewsImageMapper.toDTO(newsImage);
    }

    @Override
    public List<NewsImageDTO> GetAllNewsImage() {
        List<NewsImage> newsImages = newsImageRepository.findAll();
        return newsImages.stream().map(NewsImageMapper::toDTO).collect(Collectors.toList());
    }
}
