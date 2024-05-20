package com.example.service.Impl;

import com.example.dto.ContactFormDTO;
import com.example.entity.ContactForm;
import com.example.mapper.ContactFormMapper;
import com.example.repository.ContactFormRepository;
import com.example.service.ContactFormService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactFormImpl implements ContactFormService {
    ContactFormRepository contactFormRepository;

    public ContactFormImpl(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @Override
    public void SendContactForm(ContactFormDTO contactFormDTO) {
        ContactForm contactForm = ContactFormMapper.toEntity(contactFormDTO);
        contactFormRepository.save(contactForm);
    }

    @Override //tek sıkıntısı DTO şeklinde çekemiyorum.
    public List<ContactFormDTO> GetContactForm() {
        List<ContactForm> contactForms = contactFormRepository.findAll();
        if (contactForms.size() <= 3) {
            return maptoDTO(contactForms);
        } else {
            List<ContactForm> contactFormsShuffle = new ArrayList<>(contactForms);
            Collections.shuffle(contactFormsShuffle, new Random());
            return maptoDTO(contactFormsShuffle.subList(0, 3));
        }
    }

    private List<ContactFormDTO> maptoDTO(List<ContactForm> contactForms) {
        List<ContactFormDTO> dtoList = new ArrayList<>();
        for (ContactForm contactForm : contactForms) {
            dtoList.add(ContactFormMapper.toDTO(contactForm));
        }
        return dtoList;
    }
}
