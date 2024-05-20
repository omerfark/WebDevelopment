package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "socialmedia")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socialmedia_id")
    private int socialmedia_id;

    @Column(name = "socialmedia_name")
    private String socialmedia_name;

    @Column(name = "socialmedia_link")
    private String socialmedia_link;

    @Column(name = "isdelete")
    private boolean isdelete;
}