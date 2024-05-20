package com.example.service.Impl;

import com.example.dto.EducationDTO;
import com.example.dto.EducationStepDTO;
import com.example.entity.Education;
import com.example.entity.EducationStep;
import com.example.mapper.EducationMapper;
import com.example.mapper.EducationStepMapper;
import com.example.repository.EducationRepository;
import com.example.repository.EducationStepRepository;
import com.example.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EducationImpl implements EducationService {

    EducationRepository educationRepository;
    EducationStepRepository educationStepRepository;


    public EducationImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public String CreateEducation(EducationDTO educationDTO) {
        Education education = EducationMapper.toEntity(educationDTO);
        educationRepository.save(education);
        return "Education Created";
    }

    @Override
    public EducationDTO GetByIdEducation(int education_id) {
        Education education = educationRepository.findById((long) education_id).orElseThrow(() -> new RuntimeException("Education is not found"));
        return EducationMapper.toDTO(education);
    }


    @Override
    public  List<EducationDTO> GetAllEducation(){
        List<Education> educations = educationRepository.findAll();
        return educations.stream().map(EducationMapper::toDTO).collect(Collectors.toList());
    }


    @Override
    public List<EducationDTO> GetMainAllEducation() {
        List<Education> educations = educationRepository.findAll();

        if (educations.size() <= 3) {
            return mapDTO(educations);
        } else {
            List<Education> LastEducation = new ArrayList<>(educations);
            Collections.lastIndexOfSubList(educations,LastEducation);
            return mapDTO(LastEducation.subList(0, 4));
        }
    }

    private List<EducationDTO> mapDTO(List<Education> educations) {
        List<EducationDTO> dtoList = new ArrayList<>();
        for (Education education : educations) {
            dtoList.add(EducationMapper.toDTO(education));
        }
        return dtoList;
    }

    @Override
    public void DeleteByIdEducation(int education_id) {
        educationRepository.deleteById((long) education_id);
    }


    /*
    @Override
    public List<EducationDTO> GetAllEducation() {
        List<Education> educations = educationRepository.findAll();

        if (educations.size() <= 3) {
            return mapDTO(educations);
        } else {
            List<Education> LastEducation = new ArrayList<>(educations);
            Collections.lastIndexOfSubList(educations,LastEducation);
            return mapDTO(LastEducation.subList(0, 4));
        }
    }
*/


    /*if (educations.size() <= 3) {
                return mapDTO(educations);
            } else {
                List<Education> LastEducation = new ArrayList<>(educations);
                Collections.lastIndexOfSubList(educations,LastEducation);
                return mapDTO(LastEducation.subList(0, 4));
            }*/
        /*{if (educations.size() <= 3) {
            return mapDTO(educations);
        } else {
            List<Education> educationShuffle = new ArrayList<>(educations);
            Collections.shuffle(educationShuffle, new Random());
            return mapDTO(educationShuffle.subList(0, 4));
        }}*/
}
