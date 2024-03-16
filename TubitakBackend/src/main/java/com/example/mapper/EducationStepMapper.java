package com.example.mapper;

import com.example.dto.EducationStepDTO;
import com.example.entity.EducationStep;
import org.modelmapper.ModelMapper;

public class EducationStepMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static EducationStepDTO toDTO(EducationStep educationStep) {
        return modelMapper.map(educationStep, EducationStepDTO.class);
    }

    public static EducationStep toEntity(EducationStepDTO educationStepDTO) {
        return modelMapper.map(educationStepDTO, EducationStep.class);
    }
}
