package com.example.mapper;

import com.example.dto.EducationDTO;
import com.example.entity.Education;
import org.modelmapper.ModelMapper;

public class EducationMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static EducationDTO toDTO(Education education) {
        return modelMapper.map(education, EducationDTO.class);
    }

    public static Education toEntity(EducationDTO educationDTO) {
        return modelMapper.map(educationDTO, Education.class);
    }
}
