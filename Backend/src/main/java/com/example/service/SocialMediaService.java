package com.example.service;

import com.example.dto.SocialMediaDTO;

import java.util.List;

public interface SocialMediaService {
    public List<SocialMediaDTO> GetAllSocialMedia();
    public void CreateSocialMedia(SocialMediaDTO socialMediaDTO);
}
