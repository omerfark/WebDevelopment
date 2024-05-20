package com.example.service.Impl;

import com.example.dto.EducationDTO;
import com.example.dto.EducationStepDTO;
import com.example.entity.EducationStep;
import com.example.mapper.EducationStepMapper;
import com.example.repository.EducationStepRepository;
import com.example.service.EducationService;
import com.example.service.EducationStepService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationStepImpl implements EducationStepService {
    EducationStepRepository educationStepRepository;

    public EducationStepImpl(EducationStepRepository educationStepRepository) {
        this.educationStepRepository = educationStepRepository;
    }
    @Override
    public String CreateEducationStep(EducationStepDTO educationStepDTO) {
        EducationStep educationStep = EducationStepMapper.toEntity(educationStepDTO);
        educationStepRepository.save(educationStep);
        return "Education Step Created";
    }

    @Override
    public EducationStepDTO GetByIdEducationStep(int educationstep_id) {
        EducationStep educationStep = educationStepRepository.findById((long)educationstep_id).orElseThrow(()->new RuntimeException("Education Step is not found"));
        return EducationStepMapper.toDTO(educationStep);
    }

    @Override
    public void DeleteByIdEducationStep(int educationstep_id) {
        educationStepRepository.deleteById((long) educationstep_id);
    }

    @Override
    public List<EducationStepDTO> GetAllEducationStep() {
        List<EducationStep> educationSteps = educationStepRepository.findAll();
        return educationSteps.stream().map(EducationStepMapper::toDTO).collect(Collectors.toList());
    }

}
