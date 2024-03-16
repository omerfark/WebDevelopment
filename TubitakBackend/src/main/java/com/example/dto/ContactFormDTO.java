package com.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactFormDTO {
    private String contactForm_name;
    private String contactForm_email;
    private String contactForm_title;
    private String contactForm_mesaj;
}