package com.example.service;

import com.example.dto.EducationDTO;

import java.util.List;

public interface EducationService {
    public String CreateEducation(EducationDTO educationDTO);
    public EducationDTO GetByIdEducation(int education_id);
    public List<EducationDTO> GetAllEducation();
    public  List<EducationDTO> GetMainAllEducation();
    public void DeleteByIdEducation(int education_id);
}
