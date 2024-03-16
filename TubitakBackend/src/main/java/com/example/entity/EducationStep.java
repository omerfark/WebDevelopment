package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "educationstep")
public class EducationStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "educationstep_id")
    private int educationstep_id;

    @Column(name = "educationstep_title")
    private String educationstep_title;

    @Column(name = "educationstep_content")
    private String educationstep_content;

    @Column(name = "educationstep_image")
    private byte[] educationstep_image;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "change_date")
    @UpdateTimestamp
    private Timestamp change_date;

    @Column(name = "isdelete")
    private boolean isdelete;

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "education_id")
    private Education education_id;
}
