package com.example.service;

import com.example.dto.AboutUstDTO;
import com.example.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    public void CreateContact(ContactDTO contactDTO);
    public ContactDTO GetByIdContact(int contact_id);
}
