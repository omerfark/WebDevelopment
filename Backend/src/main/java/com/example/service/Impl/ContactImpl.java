package com.example.service.Impl;

import com.example.dto.ContactDTO;
import com.example.entity.AboutUs;
import com.example.entity.Contact;
import com.example.mapper.AboutUsMapper;
import com.example.mapper.ContactMapper;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactImpl implements ContactService {
    ContactRepository contactRepository;

    public ContactImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public void CreateContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.toEntity(contactDTO);
        contactRepository.save(contact);
    }

    @Override
    public ContactDTO GetByIdContact(int contact_id) {
        Contact contact = contactRepository.findById((long) contact_id).orElseThrow(() -> new RuntimeException("Contact is not found"));
        return ContactMapper.toDTO(contact);
    }


}
