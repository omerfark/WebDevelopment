package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int education_id;

    @Column(name = "education_name")
    private String education_name;

    @Column(name = "education_educator")
    private String education_educator;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "change_date")
    @UpdateTimestamp
    private Timestamp change_date;

    @Column(name = "isdelete")
    private boolean isdelete;

    @Column(name = "education_content")
    private String education_content;
}