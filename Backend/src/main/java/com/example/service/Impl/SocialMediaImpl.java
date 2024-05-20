package com.example.service.Impl;

import com.example.dto.SocialMediaDTO;
import com.example.entity.SocialMedia;
import com.example.mapper.SocialMediaMapper;
import com.example.repository.SocialMediaRepository;
import com.example.service.SocialMediaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMediaImpl implements SocialMediaService {
    SocialMediaRepository socialMediaRepository;
    public SocialMediaImpl(SocialMediaRepository socialMediaRepository) {
        this.socialMediaRepository = socialMediaRepository;
    }

    @Override
    public void CreateSocialMedia(SocialMediaDTO socialMediaDTO) {
        SocialMedia socialMedia = SocialMediaMapper.toEntity(socialMediaDTO);
        socialMediaRepository.save(socialMedia);
    }

    @Override
    public List<SocialMediaDTO> GetAllSocialMedia() {
        List<SocialMedia> socialMedia = socialMediaRepository.findAll();
        return socialMedia.stream().map(SocialMediaMapper::toDTO).collect(Collectors.toList());
    }
}
