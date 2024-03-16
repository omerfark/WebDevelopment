package com.example.mapper;

import com.example.dto.ContactFormDTO;
import com.example.entity.ContactForm;
import org.modelmapper.ModelMapper;

public class ContactFormMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ContactFormDTO toDTO(ContactForm contactForm){
        return modelMapper.map(contactForm,ContactFormDTO.class);
    }

    public static ContactForm toEntity(ContactFormDTO contactFormDTO){
        return modelMapper.map(contactFormDTO, ContactForm.class);
    }
}
