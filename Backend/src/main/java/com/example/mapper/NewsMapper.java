package com.example.mapper;

import com.example.dto.NewsDTO;
import com.example.dto.NewsImageDTO;
import com.example.entity.News;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;

public class NewsMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static NewsDTO toDTO(News news){
        return modelMapper.map(news,NewsDTO.class);
    }

    public static News toEntity(NewsDTO newsDTO){
        return modelMapper.map(newsDTO, News.class);
    }
}
