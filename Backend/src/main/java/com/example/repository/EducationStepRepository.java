package com.example.repository;

import com.example.entity.Education;
import com.example.entity.EducationStep;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EducationStepRepository extends JpaRepository<EducationStep, Long> {

}
