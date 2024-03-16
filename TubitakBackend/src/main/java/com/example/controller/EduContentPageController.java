package com.example.controller;

import com.example.dto.EducationStepDTO;
import com.example.service.EducationStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("educontent")
public class EduContentPageController {
    EducationStepService educationStepService;

    @Autowired
    public EduContentPageController(EducationStepService educationStepService) {
        this.educationStepService = educationStepService;
    }

    @GetMapping("/get/{educationstep_id}")
    private EducationStepDTO getEducationContent(@PathVariable int educationstep_id) {
        return educationStepService.GetByIdEducationStep(educationstep_id);
    }

    @GetMapping("/getall")
    private List<EducationStepDTO> getAllEducationStep(){

        return educationStepService.GetAllEducationStep();
    }

    @PostMapping("/post")
    private void createEducationContent(@RequestBody EducationStepDTO educationStepDTO) {
        educationStepService.CreateEducationStep(educationStepDTO);
    }

    @DeleteMapping("/delete")
    private String deleteEducationContent(int educationstep_id) {
        educationStepService.DeleteByIdEducationStep(educationstep_id);
        return "deleted";
    }


}