package com.example.service.Impl;

import com.example.dto.AboutUstDTO;
import com.example.entity.AboutUs;
import com.example.mapper.AboutUsMapper;
import com.example.repository.AboutUsRepository;
import com.example.service.AboutUsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsImpl implements AboutUsService {

    AboutUsRepository aboutUsRepository;

    public AboutUsImpl(AboutUsRepository aboutUsRepository) {
        this.aboutUsRepository = aboutUsRepository;
    }

    @Override
    public void CreateAboutUs(AboutUstDTO aboutUstDTO) {
        AboutUs aboutUs = AboutUsMapper.toEntity(aboutUstDTO);
        aboutUsRepository.save(aboutUs);
    }

    @Override
    public AboutUstDTO GetByIdAboutus(int aboutus_id) {
        AboutUs aboutUs = aboutUsRepository.findById((long) aboutus_id).orElseThrow(() -> new RuntimeException("Abutus is not found"));
        return AboutUsMapper.toDTO(aboutUs);
    }

    @Override
    public List<AboutUstDTO> GetAllAboutUs(){
        List<AboutUs> aboutUses = aboutUsRepository.findAll();
        return aboutUses.stream().map(AboutUsMapper::toDTO).collect(Collectors.toList());
    }
}
