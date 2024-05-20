package com.example.mapper;

import com.example.dto.SocialMediaDTO;
import com.example.entity.SocialMedia;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;

public class SocialMediaMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static SocialMediaDTO toDTO(SocialMedia socialMedia){
        return modelMapper.map(socialMedia, SocialMediaDTO.class);
    }

    public static SocialMedia toEntity(SocialMediaDTO socialMediaDTO){
        return modelMapper.map(socialMediaDTO, SocialMedia.class);
    }
}
