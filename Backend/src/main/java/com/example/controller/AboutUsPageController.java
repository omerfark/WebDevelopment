package com.example.controller;

import com.example.dto.AboutUstDTO;
import com.example.service.AboutUsService;
import com.example.service.SocialMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aboutus")
public class AboutUsPageController {

    SocialMediaService socialMediaService;
    AboutUsService aboutUsService;

    @Autowired
    public AboutUsPageController(AboutUsService aboutUsService, SocialMediaService socialMediaService) {
        this.aboutUsService = aboutUsService;
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getall")
    private List<AboutUstDTO> getAboutUsDetails() {
        return aboutUsService.GetAllAboutUs();
    }

    @GetMapping("/get")
    private AboutUstDTO getByIdAboutus(Integer aboutus_id){
        return aboutUsService.GetByIdAboutus(aboutus_id);
    }

    @PostMapping("/post")
    private String createAboutUsDetails(@RequestBody AboutUstDTO aboutUstDTO){
        aboutUsService.CreateAboutUs(aboutUstDTO);
        return "AboutUs Created";
    }


}
