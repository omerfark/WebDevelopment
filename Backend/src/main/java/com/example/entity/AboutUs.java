package com.example.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;

@Data
@Entity
@Table(name = "aboutus")
public class AboutUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aboutus_id")
    private int aboutus_id;

    @Column(name = "aboutus_title")
    private String aboutus_title;

    @Column(name = "aboutus_content")
    private String aboutus_content;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "change_date")
    @UpdateTimestamp
    private Timestamp change_date;

    @Column(name = "isdelete")
    private boolean isdelete;
}