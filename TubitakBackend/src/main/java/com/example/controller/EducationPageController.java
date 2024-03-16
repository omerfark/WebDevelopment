package com.example.controller;

import com.example.dto.EducationDTO;
import com.example.dto.EducationStepDTO;
import com.example.entity.Education;
import com.example.service.EducationService;
import com.example.service.EducationStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Education")
public class EducationPageController {
    EducationService educationService;
    EducationStepService educationStepService;

    @Autowired
    public EducationPageController(EducationService educationService, EducationStepService educationStepService) {
        this.educationService = educationService;
        this.educationStepService = educationStepService;
    }

    @GetMapping("/getall")
    private List<EducationDTO> getAllEducation(){
        return educationService.GetAllEducation();
    }

    @GetMapping("/getmainall")
    private List<EducationDTO> getMainAllEducation(){
        return educationService.GetMainAllEducation();
    }

    @GetMapping("/get/{education_id}")
    private EducationDTO getEducationName(@PathVariable int education_id) {
        return educationService.GetByIdEducation(education_id);
    }

    @PostMapping("/post")
    private void createEducationName(@RequestBody EducationDTO educationDTO) {
        educationService.CreateEducation(educationDTO);
    }

    @DeleteMapping("/delete")
    private void deleteEducationName(int education_id) {
        educationService.DeleteByIdEducation(education_id);
    }


    @GetMapping("/getedustep")
    private EducationStepDTO getEduStep(int educationstep_id){
        return educationStepService.GetByIdEducationStep(educationstep_id);
    }

    @PostMapping("/postedustep")
    private String createEduStep(@RequestBody EducationStepDTO educationStepDTO){
        educationStepService.CreateEducationStep(educationStepDTO);
        return "Education Step Created...";

    }

}