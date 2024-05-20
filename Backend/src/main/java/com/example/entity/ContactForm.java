package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "contactform")
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactform_id")
    private int contactform_id;

    @Column(name = "contactform_name")
    private String contactform_name;

    @Column(name = "contactform_email")
    private String contactform_email;

    @Column(name = "contactform_title")
    private String contactform_title;

    @Column(name = "contactform_mesaj")
    private String contactform_mesaj;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "isdelete")
    private boolean isdelete;
}