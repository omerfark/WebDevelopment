package com.example.service;

import com.example.dto.EducationDTO;
import com.example.dto.EducationStepDTO;
import com.example.entity.EducationStep;

import java.util.List;

public interface EducationStepService {
    public String CreateEducationStep(EducationStepDTO educationStepDTO);
    public EducationStepDTO GetByIdEducationStep(int educationstep_id);
    public void DeleteByIdEducationStep(int educationstep_id);

    public List<EducationStepDTO> GetAllEducationStep();
}
