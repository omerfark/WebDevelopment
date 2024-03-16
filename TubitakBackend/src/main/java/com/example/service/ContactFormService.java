package com.example.service;

import com.example.dto.ContactFormDTO;
import com.example.entity.ContactForm;

import java.util.List;

public interface ContactFormService {
    public void SendContactForm(ContactFormDTO contactFormDTO);

    public List<ContactFormDTO> GetContactForm();
}
