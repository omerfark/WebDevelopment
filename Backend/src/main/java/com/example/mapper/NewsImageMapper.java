package com.example.mapper;

import com.example.dto.NewsImageDTO;
import com.example.entity.NewsImage;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public class NewsImageMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    static {
        // Eşleme kurallarını belirleme
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public static NewsImageDTO toDTO(NewsImage newsImage) {
        return modelMapper.map(newsImage, NewsImageDTO.class);
    }

    public static NewsImage toEntity(NewsImageDTO newsImageDTO) {
        return modelMapper.map(newsImageDTO, NewsImage.class);
    }
}
