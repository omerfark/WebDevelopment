package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "newsimage")
public class NewsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsimage_id")
    private int newsimage_id;

    @Column(name = "newsimage_name")
    private String newsimage_name;

    @Column(name = "newsimage_link")
    private byte[] newsimage_link;

    @Column(name = "isdelete")
    private boolean isdelete;

    @ManyToOne
    @JoinColumn(name = "news_id", referencedColumnName = "news_id")
    private News news_id;
}
