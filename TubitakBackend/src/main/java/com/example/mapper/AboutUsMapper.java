package com.example.mapper;

import com.example.dto.AboutUstDTO;
import com.example.entity.AboutUs;
import org.modelmapper.ModelMapper;

public class AboutUsMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static AboutUstDTO toDTO(AboutUs aboutUs) {
        return modelMapper.map(aboutUs, AboutUstDTO.class);
    }

    public static AboutUs toEntity(AboutUstDTO aboutUstDTO) {
        return modelMapper.map(aboutUstDTO, AboutUs.class);
    }
}
