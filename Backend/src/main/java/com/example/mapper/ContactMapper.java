package com.example.mapper;

import com.example.dto.ContactDTO;
import com.example.entity.Contact;
import org.modelmapper.ModelMapper;

public class ContactMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ContactDTO toDTO(Contact contact){
        return modelMapper.map(contact, ContactDTO.class);
    }

    public static Contact toEntity(ContactDTO contactDTO){
        return modelMapper.map(contactDTO, Contact.class);
    }
}
