package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private int news_id;

    @Column(name = "news_title")
    private String news_title;

    @Column(name = "news_content")
    private String news_content;

    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp create_date;

    @Column(name = "change_date")
    @UpdateTimestamp
    private Timestamp change_date;

    @Column(name = "isdelete")
    private boolean isdelete;

    @Column(name = "news_educator")
    private String news_educator;

}