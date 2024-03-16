package com.example.service;

import com.example.dto.AboutUstDTO;
import com.example.dto.EducationDTO;

import java.util.List;

public interface AboutUsService {
    public  void CreateAboutUs(AboutUstDTO aboutUstDTO);
    public AboutUstDTO GetByIdAboutus(int aboutus_id);
    public List<AboutUstDTO> GetAllAboutUs();
}
