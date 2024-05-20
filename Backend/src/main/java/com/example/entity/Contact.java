package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contact_id;

    @Column(name = "contact_address")
    private String contact_address;

    @Column(name = "contact_tel")
    private String contact_tel;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "change_date")
    @UpdateTimestamp
    private Timestamp change_date;

    @Column(name = "isdelete")
    private boolean isdelete;

}